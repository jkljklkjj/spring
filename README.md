# 中国软件杯讯飞星火教育赛道
1. api的调用
   我们参加的赛道要求用上讯飞星火提供的api，目前打算做的功能有：背诵助手
   ### 背诵助手
   （1）调用语音听写api：https://www.bookstack.cn/read/xfyun-rest_api/cdf5fc32953f6393.md
这里的链接是java的示例sdk：https://www.xfyun.cn/sdk/dispatcher
   （2）后端接收app发送的语音文件，然后把这个语音文件配合标头发送给api，接收返回的字符串
   （3）采用爬虫爬取该诗词原文，用拼音来匹配字符串，正确则标绿，错误则标红，无则标灰
