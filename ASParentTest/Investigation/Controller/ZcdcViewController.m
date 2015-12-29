//
//  ZcdcViewController.m
//  ASParentTest
//
//  Created by 张浩 on 15/11/20.
//  Copyright © 2015年 周德艺. All rights reserved.
//

#import "ZcdcViewController.h"
#import "InvestigationTableViewCell.h"
#import "ZcdcDetailViewController.h"
#import "ZcdcObject.h"
//接口
#import "DYRequestBase+GetZcdcList.h"
@interface ZcdcViewController ()

@end

@implementation ZcdcViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    self.title = @"政策调查";
    // Do any additional setup after loading the view from its nib.
    //下拉刷新
    self.tableView.header = [MJRefreshNormalHeader headerWithRefreshingBlock:^{
        self.currentPage = 1;
        [self getZcdcListWithCurrentPage:self.currentPage andRowOfPage:@"10"];
    }];
    // 上拉刷新方法1
    self.tableView.footer = [MJRefreshBackNormalFooter footerWithRefreshingBlock:^{
        if (self.currentPage == self.allPages) {
            [PublicObject showHUDView:self.view title:@"已经是最后一页" content:@"" time:1 andCodes:^{
                [self.tableView.footer endRefreshing];
            }];
        }else{
            self.currentPage++;
        [self getZcdcListWithCurrentPage:self.currentPage andRowOfPage:@"10"];
        }
    }];
}
-(void)viewWillAppear:(BOOL)animated{
    [super viewWillAppear:YES];
    self.dataArr = [[NSMutableArray alloc]init];
    [self.tableView.header beginRefreshing];
}
- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}
-(void)getZcdcListWithCurrentPage:(NSInteger)currentPage andRowOfPage:(NSString *)rowOfPage{
    AccoutObject *userObj = [PublicObject getUserInfoDefault];
    [DYRequestBase GetZcdcListByUserId:userObj.idcode CurrentPageNum:[NSString stringWithFormat:@"%ld",(long)currentPage] RowOfPage:rowOfPage requestStartBlock:^{
        [PublicObject showHUDBegain:self.view title:@"正在获取……"];
    } responseBlock:^(id dataObj, NSError *error) {
        [PublicObject dissMissHUDEnd];
        [self.tableView.header endRefreshing];
        [self.tableView.footer endRefreshing];
        if (dataObj) {
            int status = [[dataObj objectForKey:@"status"] intValue];
            NSString *msg = [PublicObject convertNullString:[dataObj objectForKey:@"msg"]];
            if (status == 0) {
                self.allPages = [[[dataObj objectForKey:@"pageInfo"] objectForKey:@"allPageNum"] intValue];
                NSArray *objArr = [dataObj objectForKey:@"list"];
                NSLog(@"%@",objArr);
                //json转对象
                for (int i = 0; i < objArr.count; i++) {
                    NSDictionary *dic = [objArr objectAtIndex:i];
                    ZcdcObject *zcdcObj = [ZcdcObject mj_objectWithKeyValues:dic];
                    [self.dataArr addObject:zcdcObj];
                }
                [self.tableView reloadData];
            } else {
                [PublicObject showHUDView:self.view title:msg content:@"" time:kHUDTime andCodes:^{
                }];
            }
        }else{
            [PublicObject showHUDView:self.view title:@"请求失败" content:@"" time:kHUDTime andCodes:^{
            }];
        }
    }];
}
-(NSInteger)numberOfSectionsInTableView:(UITableView *)tableView{
    return 1;
}
-(NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section{
    return self.dataArr.count;
}
-(UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath{
    //1.加载xib
    static NSString *CellIdentifier = @"InvestigationTableViewCell";
    InvestigationTableViewCell *cell = (InvestigationTableViewCell *)[tableView dequeueReusableCellWithIdentifier:CellIdentifier];
    
    if (cell == nil) {
        NSBundle *bundle = [NSBundle mainBundle];
        NSArray *nibArray = [bundle loadNibNamed:CellIdentifier owner:self options:nil];
        cell = (InvestigationTableViewCell *)[nibArray objectAtIndex:0];
        [cell setSelectionStyle:UITableViewCellSelectionStyleNone];
        cell.accessoryType = UITableViewCellAccessoryDisclosureIndicator;
    }
    cell.pointImg.backgroundColor = MainColor;
    //将pointImg图层的边框设置为圆脚
    cell.pointImg.layer.cornerRadius = 5;
    cell.pointImg.layer.masksToBounds = YES;
    ZcdcObject *zcdcObj = [self.dataArr objectAtIndex:indexPath.row];
    cell.infoLab.text = zcdcObj.sheader;
    return cell;
}
-(CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath{
    return 44;
}
-(void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath{
    ZcdcDetailViewController *zcdcDetailVC = [[ZcdcDetailViewController alloc]initWithNibName:@"ZcdcDetailViewController" bundle:nil];
    zcdcDetailVC.zcdcObj = [self.dataArr objectAtIndex:indexPath.row];
    [self.navigationController pushViewController:zcdcDetailVC animated:YES];
}

@end