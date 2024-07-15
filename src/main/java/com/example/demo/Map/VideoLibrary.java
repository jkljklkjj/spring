package com.example.demo.Map;

import java.util.*;

public class VideoLibrary {
    private static Map<String, List<Video>> libraries = new HashMap<>();

    // 静态初始化块
    static {
        // 直接添加视频数据，并指定分类
        addVideo("语文", new Video("https://cn-hljheb-ct-01-05.bilivideo.com/upgcxcode/93/24/1149862493/1149862493_nb3-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1721035098&gen=playurlv2&os=bcache&oi=2043500563&trid=00002ef12d839c5a4f23943d7efd636ecae4h&mid=0&platform=html5&og=cos&upsig=05a41b779c15ada1768915b357c56aa4&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=3844&bvc=vod&nettype=0&f=h_0_0&bw=12605&logo=80000000", "http://i0.hdslb.com/bfs/archive/1fb2aa2bcc766112dc09f7f93a755a4fa971e530.jpg", "教你语文大题模版！"));
        addVideo("语文", new Video("https://cn-hljheb-ct-01-03.bilivideo.com/upgcxcode/63/48/1613114863/1613114863-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1721035380&gen=playurlv2&os=bcache&oi=2043500563&trid=0000eccfa5f2fd6b4867bce327d3610e4a07h&mid=0&platform=html5&og=cos&upsig=f675ed53f59de235d6e6a359d0792201&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=3842&bvc=vod&nettype=0&f=h_0_0&bw=45649&logo=80000000", "http://i2.hdslb.com/bfs/archive/b5ed8a9cb478209e02465d4380f84ad8b63520ec.jpg", "学了十八年都没搞懂的语法？一个视频搞懂了丨国家玮-高中语文"));
        addVideo("语文", new Video("https://cn-jsnt-ct-01-04.bilivideo.com/upgcxcode/56/22/419672256/419672256-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1721035573&gen=playurlv2&os=bcache&oi=2043500563&trid=000059130b0843844dfba86c95b2931f36d6h&mid=0&platform=html5&og=hw&upsig=4052bd7bbd6b3f0f2ce51204a79b591e&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=4276&bvc=vod&nettype=0&f=h_0_0&bw=53406&logo=80000000", "http://i2.hdslb.com/bfs/archive/f600099f9870664515eff7822ffa56d2c1479621.jpg", "高考语文142❓我这样学语文"));
        addVideo("语文",new Video("https://cn-ahwh-ct-01-06.bilivideo.com/upgcxcode/02/48/1188134802/1188134802_nb3-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1721035988&gen=playurlv2&os=bcache&oi=2043500563&trid=0000d479285462f54227ba4b9e951a122073h&mid=0&platform=html5&og=hw&upsig=833cb202cb3fc75b589ba86ef2a527d5&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=63406&bvc=vod&nettype=0&f=h_0_0&bw=24420&logo=80000000","http://i2.hdslb.com/bfs/archive/6d4dd1926c58fdea9edd9eb37d59ae4eeef3351b.jpg","高考语文！快速提分？没有捷径！只有辛苦！"));
        addVideo("语文",new Video("https://cn-hljheb-ct-01-01.bilivideo.com/upgcxcode/76/95/1143969576/1143969576_nb3-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1721036086&gen=playurlv2&os=bcache&oi=2043500563&trid=00004c34cba5b4c344bdbda53cd4c5fab7b6h&mid=0&platform=html5&og=hw&upsig=d2c1baaeb49011f70295064fee048150&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=3840&bvc=vod&nettype=0&f=h_0_0&bw=31908&logo=80000000","http://i0.hdslb.com/bfs/archive/7a114273341c6804155a4ba5ab8febca7a594350.jpg","重点高中语文课讲什么？一些信息差分享"));
        addVideo("数学",new Video("https://cn-jsnt-ct-01-19.bilivideo.com/upgcxcode/77/22/1248112277/1248112277-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1721036280&gen=playurlv2&os=bcache&oi=2043500563&trid=0000d5c2ca980e0c4a5fb05d8f89f55b7e2eh&mid=0&platform=html5&og=cos&upsig=fff165b9a64c0edfd035a6de433d24ed&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=9927&bvc=vod&nettype=0&f=h_0_0&bw=52934&logo=80000000","http://i2.hdslb.com/bfs/archive/5cb23b3f9d4b67508982d012c0bd06395f1550a7.jpg","如何才能学好“高中数学”？【经验方法+弯路梳理】"));
        addVideo("数学",new Video("https://cn-zjjh-ct-04-15.bilivideo.com/upgcxcode/89/11/1419461189/1419461189-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1721036653&gen=playurlv2&os=bcache&oi=2043500563&trid=0000728f8904209740ba92b9aceaba46d961h&mid=0&platform=html5&og=cos&upsig=5c0c2f346946ba07aea341445f09dcd8&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=22222&bvc=vod&nettype=0&f=h_0_0&bw=50584&logo=80000000","http://i1.hdslb.com/bfs/archive/3b735df3659958e23bbd7c5e82a1e8b7e3212e4c.jpg","「高中数学」 245 秒能学完 3 年的内容？"));
        addVideo("数学",new Video("https://upos-sz-mirrorcos.bilivideo.com/upgcxcode/73/78/848737873/848737873-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1721036850&gen=playurlv2&os=cosbv&oi=2043500563&trid=2e3c7f54d82b4f2e894ca7886305e7f4h&mid=0&platform=html5&og=cos&upsig=026134985836402a8e7d0378f946c6ee&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&bvc=vod&nettype=0&f=h_0_0&bw=53892&logo=80000000","http://i0.hdslb.com/bfs/archive/51b4a41b96d654472ea1c8f45cabfe5784ec3517.jpg","为什么有500万高中生跟不上高中数学"));
        addVideo("数学",new Video("https://cn-hljheb-ct-01-07.bilivideo.com/upgcxcode/49/93/1512849349/1512849349-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1721038362&gen=playurlv2&os=bcache&oi=2043500563&trid=0000fbfb33c0427340898831189f7b72b629h&mid=0&platform=html5&og=cos&upsig=b15f4185f00764ae1a16f8d9af95148a&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=3848&bvc=vod&nettype=0&f=h_0_0&bw=14308&logo=80000000","http://i1.hdslb.com/bfs/archive/79a8a3dc74bc951796405b2462fac15bb6bfda7c.jpg","高中数学知识点复习，速过带学，高考复习必看！"));
        addVideo("数学",new Video("https://cn-xj-ct-01-02.bilivideo.com/upgcxcode/48/47/1306614748/1306614748-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1721038514&gen=playurlv2&os=bcache&oi=2043500563&trid=00004c704b0b5ff049b3a368fe7cb62981f2h&mid=0&platform=html5&og=cos&upsig=8b75f39743004381313fa652c66a2a33&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=87002&bvc=vod&nettype=0&f=h_0_0&bw=49934&logo=80000000","http://i0.hdslb.com/bfs/archive/82d5df63111316ab275efe91c22fbeaf411df583.jpg","【干爆数学】挑战让所有高中数学老师失业"));
        addVideo("英语",new Video("https://cn-hljheb-ct-01-08.bilivideo.com/upgcxcode/11/86/1331148611/1331148611-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1721038614&gen=playurlv2&os=bcache&oi=2043500563&trid=000072660ef6a8e646a5aec4c55fc17912e0h&mid=0&platform=html5&og=cos&upsig=826194d4e1364edee9cd4abb5b257cd2&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=3849&bvc=vod&nettype=0&f=h_0_0&bw=53679&logo=80000000","http://i0.hdslb.com/bfs/archive/0c6c93ec90eca402a33717eb784d699556311a97.jpg","【英语140+】一个视频彻底教会你怎么学英语"));
        addVideo("英语",new Video("https://cn-sccd-ct-01-30.bilivideo.com/upgcxcode/49/85/144318549/144318549-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1721038725&gen=playurlv2&os=bcache&oi=2043500563&trid=000061a1ba1934d54e4ca7fedada8127d6d6h&mid=0&platform=html5&og=cos&upsig=1aa13785727c3d9da778a0634ebba209&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=62630&bvc=vod&nettype=0&f=h_0_0&bw=58047&logo=80000000","http://i2.hdslb.com/bfs/archive/b74d672dcca72563609045b76b28793a73a3b88a.jpg","【高中英语】高一高二就能140+，这就是全网最强英语学习方法？"));
        addVideo("英语",new Video("https://cn-jsnt-ct-01-03.bilivideo.com/upgcxcode/49/30/1230493049/1230493049-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1721038969&gen=playurlv2&os=bcache&oi=2043500563&trid=0000fb31a631f7914383957317ccc472d794h&mid=0&platform=html5&og=hw&upsig=82b2466bd4e5b1b2b342cb7006509d41&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=4275&bvc=vod&nettype=0&f=h_0_0&bw=30304&logo=80000000","http://i2.hdslb.com/bfs/archive/dc9a5c520f7176c7bf8ff246e90eecd44ba8bb09.jpg","https://cn-sccd-ct-01-30.bilivideo.com/upgcxcode/49/85/144318549/144318549-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1721038725&gen=playurlv2&os=bcache&oi=2043500563&trid=000061a1ba1934d54e4ca7fedada8127d6d6h&mid=0&platform=html5&og=cos&upsig=1aa13785727c3d9da778a0634ebba209&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=62630&bvc=vod&nettype=0&f=h_0_0&bw=58047&logo=80000000"));
        addVideo("英语",new Video("https://upos-sz-mirror08c.bilivideo.com/upgcxcode/99/90/993119099/993119099_nb3-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1721039026&gen=playurlv2&os=08cbv&oi=2043500563&trid=7f3d0af7ca434c3c917167b7dcb95df7h&mid=0&platform=html5&og=hw&upsig=22284204f0be9e66b6622eaf656da1c2&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&bvc=vod&nettype=0&f=h_0_0&bw=11688&logo=80000000","http://i2.hdslb.com/bfs/archive/f676d70d659790143d192436db588ec70ee85a85.jpg","马上要高考了，这可能是唯一让你英语翻盘的机会！"));
        addVideo("英语",new Video("https://cn-sccd-ct-01-22.bilivideo.com/upgcxcode/68/10/1128501068/1128501068_nb3-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1721039118&gen=playurlv2&os=bcache&oi=2043500563&trid=0000dc5927f3816e414caf518267a4ef5089h&mid=0&platform=html5&og=cos&upsig=299eb12c7c7eba05f674efc0445ced2a&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=62622&bvc=vod&nettype=0&f=h_0_0&bw=29402&logo=80000000","http://i2.hdslb.com/bfs/archive/e6044175ecae483fe2c5c57b693d870e544fe4f5.jpg","七选五读不懂？别怕！教你两招直接满分带回家 "));
        addVideo("物理",new Video("https://cn-hljheb-ct-01-07.bilivideo.com/upgcxcode/48/19/1012471948/1012471948_nb3-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1721039193&gen=playurlv2&os=bcache&oi=2043500563&trid=000075d3d40916284d1cb4d5237cf25038c1h&mid=0&platform=html5&og=hw&upsig=65ca09c45a45eef1bfeccee0ebea3d80&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=3848&bvc=vod&nettype=0&f=h_0_0&bw=11859&logo=80000000","http://i0.hdslb.com/bfs/archive/acb189bbe115ee34c8f399c3d30ac3959a27552c.jpg","3分钟构建高中物理知识框架"));
        addVideo("物理",new Video("https://cn-ahwh-ct-01-02.bilivideo.com/upgcxcode/66/54/717675466/717675466_nb3-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1721039253&gen=playurlv2&os=bcache&oi=2043500563&trid=0000e92a03d1dcc14af7a11f5af1a3348222h&mid=0&platform=html5&og=cos&upsig=9108c5d7902aeed5afd18cc021b8f5c2&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=63402&bvc=vod&nettype=0&f=h_0_0&bw=9837&logo=80000000","http://i1.hdslb.com/bfs/archive/c27c450c1c194e44301124f2502124f1684e2aca.jpg","36分钟复习高中物理知识要点"));
        addVideo("物理",new Video("https://cn-jsnt-ct-01-40.bilivideo.com/upgcxcode/47/67/1184646747/1184646747_nb3-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1721039310&gen=playurlv2&os=bcache&oi=2043500563&trid=0000148f444db8574e6aacf22515f28bbfebh&mid=0&platform=html5&og=hw&upsig=bfa54849e370fcf2300e4e460ee6bb1d&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=14711&bvc=vod&nettype=0&f=h_0_0&bw=17372&logo=80000000","http://i0.hdslb.com/bfs/archive/b25f524c8b4ba48c24c21465f6a72dcd959501b7.jpg","高中物理6本书难度排行"));
        addVideo("物理",new Video("https://cn-zjjh-ct-04-08.bilivideo.com/upgcxcode/73/97/774849773/774849773-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1721039396&gen=playurlv2&os=bcache&oi=2043500563&trid=0000ddd44a443cc14b1687879d285600fc61h&mid=0&platform=html5&og=hw&upsig=f3167fa6eeb167a214c31ee1f1d8adb4&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=6593&bvc=vod&nettype=0&f=h_0_0&bw=53821&logo=80000000","http://i2.hdslb.com/bfs/archive/ed99257ee9f22ab3dbcf0b5a18b066cce1ed244e.jpg","敲黑板！高中物理的教辅书怎么选！？"));
        addVideo("物理",new Video("https://cn-jsnt-ct-01-18.bilivideo.com/upgcxcode/83/53/215455383/215455383-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1721039438&gen=playurlv2&os=bcache&oi=2043500563&trid=0000c2ad9abe247e4222ac8c25502585472dh&mid=0&platform=html5&og=hw&upsig=54ab9f4131d1ee0e23189afdb00e0952&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=9926&bvc=vod&nettype=0&f=h_0_0&bw=56478&logo=80000000","http://i0.hdslb.com/bfs/archive/0e2888af9c5fc25722d8214b11ce26b9fe9b4de8.jpg","【高中物理】95+学习经验方法分享"));
        addVideo("化学",new Video("https://cn-ahwh-ct-01-06.bilivideo.com/upgcxcode/77/22/749772277/749772277-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1721039543&gen=playurlv2&os=bcache&oi=2043500563&trid=00003cee9903b55b4507aadeb4f50e9f67d6h&mid=0&platform=html5&og=cos&upsig=7bc5644f8f93529e84d046504e198ea5&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=63406&bvc=vod&nettype=0&f=h_0_0&bw=14990&logo=80000000","http://i2.hdslb.com/bfs/archive/8be8f900a955044da228a447634fb70bea916c84.jpg","【化学党必看】怎么学成绩从40到90？"));
        addVideo("化学",new Video("https://cn-jxjj-ct-01-14.bilivideo.com/upgcxcode/33/62/304326233/304326233_nb3-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1721039664&gen=playurlv2&os=bcache&oi=2043500563&trid=0000aabb12c9cc2d4e26b148eeb12f6499b1h&mid=0&platform=html5&og=hw&upsig=a696cabce3ce1ad3a19b924253d2d8b9&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=9623&bvc=vod&nettype=0&f=h_0_0&bw=27862&logo=80000000","http://i0.hdslb.com/bfs/archive/c43c5b3b178e5d650387b6bde9a9df8f97afa34b.jpg","【高考化学】一张纸讲完高考化学——竞赛退役的清华学长带你梳理知识点"));
        addVideo("化学",new Video("https://www.bilibili.com/video/BV1Uz4y1y7Zh/?spm_id_from=333.337.search-card.all.click&vd_source=395c731c3c5d20cbf3fbfcbaa55709c6","http://i2.hdslb.com/bfs/archive/557895a2ef2e58464d9a6e84f3ce888229d476aa.jpg","高中化学高效提到70分，高三的时候我做了这三件事"));
        addVideo("化学",new Video("https://cn-jsnt-ct-01-05.bilivideo.com/upgcxcode/96/01/1591640196/1591640196-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1721040550&gen=playurlv2&os=bcache&oi=2043500563&trid=000020718f817eea4efb86f918a27f9db8d0h&mid=0&platform=html5&og=hw&upsig=7a398937d09939f7b9af0b4891b61b49&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=4283&bvc=vod&nettype=0&f=h_0_0&bw=29384&logo=80000000","http://i2.hdslb.com/bfs/archive/708530ddc59d3662977c994af8e94f6f03ffa75b.jpg","高中化学底层意识，一轮复习开局起飞丨李政-高考化学"));
        addVideo("化学",new Video("https://cn-hljheb-ct-01-07.bilivideo.com/upgcxcode/94/65/839656594/839656594_nb3-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1721042343&gen=playurlv2&os=bcache&oi=2043500563&trid=000008c531a04a384997859292fd0615d6edh&mid=0&platform=html5&og=cos&upsig=4578311480f63306e3c7d96c55bee09e&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=3848&bvc=vod&nettype=0&f=h_0_0&bw=12895&logo=80000000","http://i0.hdslb.com/bfs/archive/973406a5313c05b924d4c4d7586ea3a124f47815.jpg","化学究竟如何学？颠覆你认知的方法论！"));
        addVideo("语文",new Video("视频链接","封面链接","标题"));
        addVideo("语文",new Video("视频链接","封面链接","标题"));
        addVideo("语文",new Video("视频链接","封面链接","标题"));
        addVideo("语文",new Video("视频链接","封面链接","标题"));
        addVideo("语文",new Video("视频链接","封面链接","标题"));
        addVideo("语文",new Video("视频链接","封面链接","标题"));
        addVideo("语文",new Video("视频链接","封面链接","标题"));
        addVideo("语文",new Video("视频链接","封面链接","标题"));
        addVideo("语文",new Video("视频链接","封面链接","标题"));
        addVideo("语文",new Video("视频链接","封面链接","标题"));
        addVideo("语文",new Video("视频链接","封面链接","标题"));
        addVideo("语文",new Video("视频链接","封面链接","标题"));
        addVideo("语文",new Video("视频链接","封面链接","标题"));
        addVideo("语文",new Video("视频链接","封面链接","标题"));
        addVideo("语文",new Video("视频链接","封面链接","标题"));

        // 可以继续为其他分类添加视频或为同一分类添加更多视频
    }

    // 静态方法，向指定分类添加视频
    public static void addVideo(String category, Video video) {
        // 如果该分类不存在，则创建一个新的视频列表
        libraries.computeIfAbsent(category, k -> new ArrayList<>()).add(video);
    }

    // 静态方法，获取指定分类的视频列表
    public static List<Video> getVideos(String category) {
        return libraries.getOrDefault(category, new ArrayList<>());
    }

    // 接收一个数组，将每一数组对应的每一类视频随机抽出一部分来进行返回，一共返回十个视频
    public static List<Video> getVideos(String[] categories) {
        List<Video> selectedVideos = new ArrayList<>();
        Random random = new Random();
        int totalVideosToSelect = 10;

        // 计算每个类别应该抽取的视频数量
        int videosPerCategory = totalVideosToSelect / categories.length;
        int extraVideos = totalVideosToSelect % categories.length; // 如果不能平均分配，有余数的情况

        for (String category : categories) {
            List<Video> videosInCategory = getVideos(category);
            Collections.shuffle(videosInCategory); // 打乱视频顺序以随机抽取
            int videosToSelectFromCategory = videosPerCategory + (extraVideos > 0 ? 1 : 0); // 如果有余数，优先分配
            if (extraVideos > 0) extraVideos--; // 分配了一个额外视频后，减少额外视频的数量

            // 从当前类别中抽取视频
            for (int i = 0; i < Math.min(videosToSelectFromCategory, videosInCategory.size()); i++) {
                selectedVideos.add(videosInCategory.get(i));
            }
        }
        // 如果选中的视频不足10个，可以在这里添加逻辑来处理这种情况，例如随机从已选视频中再次选择填充
        return selectedVideos;
    }

    public static void main(String args[]){
        String[] categories = {"语文", "数学", "英语"};
        List<Video> selectedVideos = getVideos(categories);
        for (Video video : selectedVideos) {
            System.out.println(video.getTitle());
        }
    }
}