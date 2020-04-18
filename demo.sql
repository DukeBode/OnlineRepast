insert into tcategory(type) values 
('甜品'),
('冷饮');
select * from tcategory;

insert into trepast(name,categoryid,unit,price,pic,info,time) values
('功夫熊猫',1,'元/1人份',19,'/index_files/meal-1.png','萌萌的外表勾起你的味蕾，浓郁的巧克力，鲜美的奶油，松软的蛋糕。让人欲罢不能',0),
('浆果慕斯',1,'元/1人份',18,'/index_files/meal-2.png','蛋糕分为两层,底座为粉红色,给人一种很温馨的感觉,上层的奶油香软可口,甜而不腻. ',0),
('四季沐歌',1,'元/1人份',18,'/index_files/meal-3.png','清凉的沙冰刺激着你的味觉。淡淡的草莓味在口中化开。给你冰凉一夏',0),
('浆果慕斯',1,'元/1人份',18,'/index_files/meal-4.png','蛋糕分为两层,底座为粉红色,给人一种很温馨的感觉,上层的奶油香软可口,甜而不腻. ',0),
('四季沐歌',1,'元/1人份',18,'/index_files/meal-5.png','清凉的沙冰刺激着你的味觉。淡淡的草莓味在口中化开。给你冰凉一夏',0),
('抹茶麻薯',1,'元/2人份',15,'/index_files/meal-6.png','清新的颜色惹人醉。Q爽的糯米在口中舞蹈。抹茶的清香散开，回味无穷',0);
select * from trepast;
