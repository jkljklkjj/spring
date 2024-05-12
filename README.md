# 中国软件杯讯飞星火教育赛道

1. api的调用
   我们参加的赛道要求用上讯飞星火提供的api，目前打算做的功能有：背诵助手
   ### 背诵助手
   （1）调用语音听写api：https://www.bookstack.cn/read/xfyun-rest_api/cdf5fc32953f6393.md
   这里的链接是java的sdk文档：https://www.xfyun.cn/doc/mscapi/Java/javarecognizer.html#%E7%B1%BBuserwords
   （2）后端接收app发送的语音文件，然后把这个语音文件配合标头发送给api，接收返回的字符串
   （3）采用爬虫爬取该诗词原文，用拼音来匹配字符串，正确则标绿，错误则标红，无则标灰

   ### 成绩分析王
   （1）记录用户发送的文本，然后用星火api返回可以识别的信息，同时也分析成绩并给出建议
   （2）识别信息后后端进行处理，返回给前端
   （3）前端挂载信息到echarts，同时也给出api给出的建议
   （4）数据库设计：以用户名为主键，以科目名为第二个键，科目名下面有一个数组，数组的一个位置有两个信息成绩和对应的日期

   ### 知识库问答
   （1）用户提出问题，后端通过api返回结果
   （2）1、文档上传：https://chatdoc.xfyun.cn/openapi/v1/file/upload
      2、文档问答：wss://chatdoc.xfyun.cn/openapi/chat
      3、发起文档总结：https://chatdoc.xfyun.cn/openapi/v1/file/summary/start
      4、获取文档总结/概要内容：https://chatdoc.xfyun.cn/openapi/v1/file/summary/query

   ### 视频个性化推荐
   （1）用户诉说希望看到的学习视频，用星火助手api返回结果
   （2）用爬虫返回对应的b站视频，用列表的形式返回给用户

   ### 反馈功能
   （1）用户可以反馈问题，前端通过表单收集后返回给后端
   （2）后端接收到后，通过一些方式存入服务器的txt之中，给我们提供一些反馈