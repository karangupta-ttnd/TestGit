show databases;
drop database LinkSharing;
use LinkSharing;

show tables;

select * from User;
describe User;
<<<<<<< Updated upstream
=======
delete from User;
>>>>>>> Stashed changes

update User set password=12345 where user_id=1;

delete from User where user_id=2;


select * from Topic;
describe Topic;


select * from Topic,User where User.user_id=Topic.createdBy_user_id and User.user_id=2;

select * from Topic left join User on User.user_id=Topic.createdBy_user_id and User.user_id=2;

select user0_.user_id as user_id1_5_0_, user0_.active as active2_5_0_, user0_.admin as admin3_5_0_, user0_.dateCreated as dateCrea4_5_0_, user0_.email as email5_5_0_, user0_.firstName as firstNam6_5_0_, user0_.lastName as lastName7_5_0_, user0_.lastUpdated as lastUpda8_5_0_, user0_.oauthid as oauthid9_5_0_, user0_.password as passwor10_5_0_, user0_.photo as photo11_5_0_, user0_.username as usernam12_5_0_ 
from User user0_ 
where user0_.user_id=?;


select * from Subscriptions;
describe Subscriptions;



select * from Resource;
describe Resource;
insert into Resource (user_id, dateCreated, description, lastUpdated, topic_topic_id, url, DTYPE)
 values (1, NOW(), " adasdsadasd", NOW(),1 , "ssads", 'resource_link');

select * from Resource r  order by lastUpdated desc;

select topic0_.topic_id as topic_id1_4_0_, topic0_.createdBy_user_id as createdB6_4_0_, topic0_.dateCreated as dateCrea2_4_0_, topic0_.lastUpdated as lastUpda3_4_0_, topic0_.name as name4_4_0_, topic0_.visibility as visibili5_4_0_, user1_.user_id as user_id1_5_1_, user1_.active as active2_5_1_, user1_.admin as admin3_5_1_, user1_.dateCreated as dateCrea4_5_1_, user1_.email as email5_5_1_, user1_.firstName as firstNam6_5_1_, user1_.lastName as lastName7_5_1_, user1_.lastUpdated as lastUpda8_5_1_, user1_.oauthid as oauthid9_5_1_, user1_.password as passwor10_5_1_, user1_.photo as photo11_5_1_, user1_.username as usernam12_5_1_
 from Topic topic0_ inner join User user1_ on topic0_.createdBy_user_id=user1_.user_id
 where topic0_.topic_id=?;


select * from ReadingItem;
describe ReadingItem;


select * from ResourceRating;
describe ResourceRating;