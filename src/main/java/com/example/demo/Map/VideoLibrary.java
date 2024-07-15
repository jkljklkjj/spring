package com.example.demo.Map;

import java.util.*;

public class VideoLibrary {
    private static Map<String, List<Video>> libraries = new HashMap<>();

    // 静态初始化块
    static {
        // 直接添加视频数据，并指定分类
        addVideo("语文", new Video("https://www.bilibili.com/video/BV1oh4y1s7Lb/?spm_id_from=333.337.search-card.all.click", "http://i0.hdslb.com/bfs/archive/1fb2aa2bcc766112dc09f7f93a755a4fa971e530.jpg", "教你语文大题模版！"));
        addVideo("语文", new Video("https://www.bilibili.com/video/BV1h1421b7yw/?spm_id_from=333.337.search-card.all.click", "http://i2.hdslb.com/bfs/archive/b5ed8a9cb478209e02465d4380f84ad8b63520ec.jpg", "学了十八年都没搞懂的语法？一个视频搞懂了丨国家玮-高中语文"));
        addVideo("语文", new Video("https://www.bilibili.com/video/BV1CL411s7VQ/?spm_id_from=333.337.search-card.all.click", "http://i2.hdslb.com/bfs/archive/f600099f9870664515eff7822ffa56d2c1479621.jpg", "高考语文142❓我这样学语文"));
        addVideo("语文",new Video("https://www.bilibili.com/video/BV1FV4y1h7LT/?spm_id_from=333.337.search-card.all.click","http://i2.hdslb.com/bfs/archive/6d4dd1926c58fdea9edd9eb37d59ae4eeef3351b.jpg","高考语文！快速提分？没有捷径！只有辛苦！"));
        addVideo("语文",new Video("https://www.bilibili.com/video/BV1Vs4y1T7QM/?spm_id_from=333.337.search-card.all.click","http://i0.hdslb.com/bfs/archive/7a114273341c6804155a4ba5ab8febca7a594350.jpg","重点高中语文课讲什么？一些信息差分享"));
        addVideo("数学",new Video("https://www.bilibili.com/video/BV1Vj41127VY/?spm_id_from=333.337.search-card.all.click","http://i2.hdslb.com/bfs/archive/5cb23b3f9d4b67508982d012c0bd06395f1550a7.jpg","如何才能学好“高中数学”？【经验方法+弯路梳理】"));
        addVideo("数学",new Video("https://www.bilibili.com/video/BV1M64y1w7C5/?spm_id_from=333.337.search-card.all.click","http://i1.hdslb.com/bfs/archive/3b735df3659958e23bbd7c5e82a1e8b7e3212e4c.jpg","「高中数学」 245 秒能学完 3 年的内容？"));
        addVideo("数学",new Video("https://www.bilibili.com/video/BV1uG4y1W7Lk/?spm_id_from=333.337.search-card.all.click","http://i0.hdslb.com/bfs/archive/51b4a41b96d654472ea1c8f45cabfe5784ec3517.jpg","为什么有500万高中生跟不上高中数学"));
        addVideo("数学",new Video("https://www.bilibili.com/video/BV15t421j7NZ/?spm_id_from=333.337.search-card.all.click","http://i1.hdslb.com/bfs/archive/79a8a3dc74bc951796405b2462fac15bb6bfda7c.jpg","高中数学知识点复习，速过带学，高考复习必看！"));
        addVideo("数学",new Video("https://www.bilibili.com/video/BV1eG411y7qJ/?spm_id_from=333.337.search-card.all.click","http://i0.hdslb.com/bfs/archive/82d5df63111316ab275efe91c22fbeaf411df583.jpg","【干爆数学】挑战让所有高中数学老师失业"));
        addVideo("英语",new Video("https://www.bilibili.com/video/BV1RQ4y187aK/?spm_id_from=333.337.search-card.all.click","http://i0.hdslb.com/bfs/archive/0c6c93ec90eca402a33717eb784d699556311a97.jpg","【英语140+】一个视频彻底教会你怎么学英语"));
        addVideo("英语",new Video("https://www.bilibili.com/video/BV1M7411i7s6/?spm_id_from=333.337.search-card.all.click","http://i2.hdslb.com/bfs/archive/b74d672dcca72563609045b76b28793a73a3b88a.jpg","【高中英语】高一高二就能140+，这就是全网最强英语学习方法？"));
        addVideo("英语",new Video("https://www.bilibili.com/video/BV1VM4y1X7Zd/?spm_id_from=333.337.search-card.all.click","http://i2.hdslb.com/bfs/archive/f676d70d659790143d192436db588ec70ee85a85.jpg","马上要高考了，这可能是唯一让你英语翻盘的机会！"));
        addVideo("英语",new Video("https://www.bilibili.com/video/BV1Xo4y1V77V/?spm_id_from=333.337.search-card.all.click","http://i2.hdslb.com/bfs/archive/e6044175ecae483fe2c5c57b693d870e544fe4f5.jpg","七选五读不懂？别怕！教你两招直接满分带回家 "));
        addVideo("物理",new Video("https://www.bilibili.com/video/BV1wj411P7AZ/?spm_id_from=333.337.search-card.all.click","http://i0.hdslb.com/bfs/archive/acb189bbe115ee34c8f399c3d30ac3959a27552c.jpg","3分钟构建高中物理知识框架"));
        addVideo("物理",new Video("https://www.bilibili.com/video/BV19t4y1s7KL/?spm_id_from=333.337.search-card.all.click","http://i1.hdslb.com/bfs/archive/c27c450c1c194e44301124f2502124f1684e2aca.jpg","36分钟复习高中物理知识要点"));
        addVideo("物理",new Video("https://www.bilibili.com/video/BV1KM4y1E7uS/?spm_id_from=333.337.search-card.all.click","http://i0.hdslb.com/bfs/archive/b25f524c8b4ba48c24c21465f6a72dcd959501b7.jpg","高中物理6本书难度排行"));
        addVideo("物理",new Video("https://www.bilibili.com/video/BV13W4y1m7Bi/?spm_id_from=333.337.search-card.all.click","http://i2.hdslb.com/bfs/archive/ed99257ee9f22ab3dbcf0b5a18b066cce1ed244e.jpg","敲黑板！高中物理的教辅书怎么选！？"));
        addVideo("物理",new Video("https://www.bilibili.com/video/BV1KV411z7aQ/?spm_id_from=333.337.search-card.all.click","http://i0.hdslb.com/bfs/archive/0e2888af9c5fc25722d8214b11ce26b9fe9b4de8.jpg","【高中物理】95+学习经验方法分享"));
        addVideo("化学",new Video("https://www.bilibili.com/video/BV1Bg411Q7Gf/?spm_id_from=333.337.search-card.all.click&vd_source=395c731c3c5d20cbf3fbfcbaa55709c6","http://i2.hdslb.com/bfs/archive/8be8f900a955044da228a447634fb70bea916c84.jpg","【化学党必看】怎么学成绩从40到90？"));
        addVideo("化学",new Video("https://www.bilibili.com/video/BV14p4y1H7tU/?spm_id_from=333.337.search-card.all.click","http://i0.hdslb.com/bfs/archive/c43c5b3b178e5d650387b6bde9a9df8f97afa34b.jpg","【高考化学】一张纸讲完高考化学——竞赛退役的清华学长带你梳理知识点"));
        addVideo("化学",new Video("https://www.bilibili.com/video/BV1Uz4y1y7Zh/?spm_id_from=333.337.search-card.all.click","http://i2.hdslb.com/bfs/archive/557895a2ef2e58464d9a6e84f3ce888229d476aa.jpg","高中化学高效提到70分，高三的时候我做了这三件事"));
        addVideo("化学",new Video("https://www.bilibili.com/video/BV1sf421B7Hk/?spm_id_from=333.337.search-card.all.click","http://i2.hdslb.com/bfs/archive/708530ddc59d3662977c994af8e94f6f03ffa75b.jpg","高中化学底层意识，一轮复习开局起飞丨李政-高考化学"));
        addVideo("化学",new Video("https://www.bilibili.com/video/BV1Dw411m7ky/?spm_id_from=333.337.search-card.all.click","http://i0.hdslb.com/bfs/archive/973406a5313c05b924d4c4d7586ea3a124f47815.jpg","化学究竟如何学？颠覆你认知的方法论！"));
        addVideo("生物",new Video("https://www.bilibili.com/video/BV1yG4y1v7vp/?spm_id_from=333.337.search-card.all.click","http://i2.hdslb.com/bfs/archive/3924c8595bd5c7965a8731db8e52b60d200f5140.jpg","怎么做到高考生物90+？"));
        addVideo("生物",new Video("https://www.bilibili.com/video/BV168411a7uK/?spm_id_from=333.337.search-card.all.click","http://i2.hdslb.com/bfs/archive/472623ff58cbba68bb712ab115bd997a945bbfe3.jpg","【生物速记】38分钟复习高中生物知识要点"));
        addVideo("生物",new Video("https://www.bilibili.com/video/BV1vX4y1b7zS/?spm_id_from=333.337.search-card.all.click","http://i2.hdslb.com/bfs/archive/f831f8e78e73d8615a113bb11fdfa6ff227d2b6e.jpg","高中生物课本中那些不被重视却考你个猝不及防的知识点！"));
        addVideo("生物",new Video("https://www.bilibili.com/video/BV1vX4y1b7zS/?spm_id_from=333.337.search-card.all.click","http://i1.hdslb.com/bfs/archive/8d359343607514921bd525ec10feab6bca8fe51e.jpg","【经验分享】高中生物94分经验分享"));
        addVideo("保研",new Video("https://www.bilibili.com/video/BV15k4y1377H/?spm_id_from=333.337.search-card.all.click","http://i1.hdslb.com/bfs/archive/41678b3860425fa017fde9ee47d7659acb9d6604.jpg","准大一大二必看｜成为无情的保研刺客 V2023｜如何从新大一走到新研一？B站最全攻略"));
        addVideo("保研",new Video("https://www.bilibili.com/video/BV1vP41147bN/?spm_id_from=333.337.search-card.all.click","http://i0.hdslb.com/bfs/archive/99c55140e2f20e24a58aa733393142be1b7a0c73.jpg","大学保研全流程"));
        addVideo("保研",new Video("https://www.bilibili.com/video/BV1y3411h7oB/?spm_id_from=333.337.search-card.all.click","http://i2.hdslb.com/bfs/archive/678308b420d71f21c852549608f3ab3ee52da20b.jpg","当代学生最大的困境！千万别让自己成为信息孤岛！"));
        addVideo("保研",new Video("https://www.bilibili.com/video/BV1pV411V7Ff/?spm_id_from=333.337.search-card.all.click","http://i1.hdslb.com/bfs/archive/8c72ef58df441164cb9ae1cb04e45223dd49b5f9.jpg","保研这件事 是如何摧毁我 又让我重获新生的"));
        addVideo("地理",new Video("https://www.bilibili.com/video/BV1Xu4y1K76p/?spm_id_from=333.337.search-card.all.click","http://i0.hdslb.com/bfs/archive/ac26bcf5097ffe02c60de998a6d0c29203dad944.jpg","【地理 90+】笑死，地理 90+不是和喝水一样简单"));
        addVideo("地理",new Video("https://www.bilibili.com/video/BV1nS421R7WG/?spm_id_from=333.337.search-card.all.click","http://i1.hdslb.com/bfs/archive/fc0bfea197321cf05a27a56493866321add645aa.jpg","【高中地理】暑假防颓废，准高三必看！"));
        addVideo("地理",new Video("https://www.bilibili.com/video/BV1gy4y1d7tP/?spm_id_from=333.337.search-card.all.click","http://i0.hdslb.com/bfs/archive/e1e464ab7111aa4316711830b2ceb512be43f8cd.jpg","你的地理，为啥学成了玄学？17min明悟地理学习法则"));
        addVideo("地理",new Video("https://www.bilibili.com/video/BV1rU4y1Y711/?spm_id_from=333.337.search-card.all.click","http://i1.hdslb.com/bfs/archive/d7641ddfe2e1786042faa2fc04c63c7ce79a5420.jpg","【地理全市状元】高三地理这样学，轻松赋分90+！一二轮复习指南/满满干货/不看后悔系列"));
        addVideo("就业",new Video("https://www.bilibili.com/video/BV1PW421d7xN/?spm_id_from=333.337.search-card.all.click","http://i2.hdslb.com/bfs/archive/3cb711613e62d71ed63045566aec8a20e7e439ac.jpg","就业压力到底有多大？2024年大学毕业生再创新高"));
        addVideo("就业",new Video("https://www.bilibili.com/video/BV14E4m1R7iq/?spm_id_from=333.337.search-card.all.click","http://i2.hdslb.com/bfs/archive/071ebc924d139ee98835969c5b4e7c30eb37c612.jpg","一年工资10万元，在全国算什么水平？我们的就业市场怎么了？"));
        addVideo("就业",new Video("https://www.bilibili.com/video/BV1qb421H7cV/?spm_id_from=333.337.search-card.all.click","http://i0.hdslb.com/bfs/archive/71144f911f22c53f8e8726378296f8967afe56f6.jpg","1200万人毕业、1300万人高考！就业市场即将迎来终极考验，我们怎么办？"));
        addVideo("就业",new Video("https://www.bilibili.com/video/BV19y411q7B8/?spm_id_from=333.337.search-card.all.click","http://i2.hdslb.com/bfs/archive/9892a3a2557f828c2536635b77b438df6b3e9a49.png","大型纪录片《下半年噩梦级就业》持续为你播出！！！！！！！！"));
        addVideo("职业规划",new Video("https://www.bilibili.com/video/BV1xP4y1T7Gc/?spm_id_from=333.337.search-card.all.click","http://i2.hdslb.com/bfs/archive/00e2437e2b530c6c0ee1dd2af31a3ee105d74c2c.jpg","“要是早几年看到这个视频就好了。”【大学生职业规划思路】"));
        addVideo("职业规划",new Video("https://www.bilibili.com/video/BV1EY4y1R7xf/?spm_id_from=333.337.search-card.all.click","http://i0.hdslb.com/bfs/archive/b9662fc7da2f5ca1396e813e495cff30b2ff51ed.jpg","10分钟讲透职业规划底层逻辑｜干货+示例 | 个人发展｜副业"));
        addVideo("职业规划",new Video("https://www.bilibili.com/video/BV1be4y1j72e/?spm_id_from=333.337.search-card.all.click","http://i0.hdslb.com/bfs/archive/9e4c4d1c107ddbfe34a749ba146a2baf20f65878.jpg","学生要早了解的真相！选择哪些行业/职业有前/钱景？"));
        addVideo("职业规划",new Video("https://www.bilibili.com/video/BV1rV4y1Y77V/?spm_id_from=333.337.search-card.all.click","http://i1.hdslb.com/bfs/archive/f5fc46c8baaea98ccad13e327a0a05dd03001fe0.jpg","年轻人的职业规划，到底有没有意义？"));
//        addVideo("语文",new Video("视频链接","封面链接","标题"));

        // 可以继续为其他分类添加视频或为同一分类添加更多视频
    }

    public static List<Video> getAllVideos() {
        List<Video> allVideos = new ArrayList<>();
        for (List<Video> videos : libraries.values()) {
            allVideos.addAll(videos);
        }
        return allVideos;
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
        String[] preSelectedVideos = {"语文", "数学", "英语", "物理", "化学", "生物", "地理", "保研", "就业", "职业规划"};

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

        //不足十个视频时，从预选视频中随机选取
        if (selectedVideos.size() < totalVideosToSelect) {
            // 需要填充的视频数量
            int shortfall = totalVideosToSelect - selectedVideos.size();
            List<Video> additionalVideos = new ArrayList<>();
            // 假设有一个方法可以获取所有视频
            List<Video> allVideos = getAllVideos();
            Collections.shuffle(allVideos); // 打乱所有视频的顺序
            for (int i = 0; i < Math.min(shortfall, allVideos.size()); i++) {
                // 确保不重复添加视频
                if (!selectedVideos.contains(allVideos.get(i))) {
                    additionalVideos.add(allVideos.get(i));
                }
            }
            // 如果额外视频仍不足以满足需求，可能需要进一步的逻辑来处理
            selectedVideos.addAll(additionalVideos);
        }
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