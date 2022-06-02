# 一、业务背景

日常开发中，我们经常要使用插件来实现JSON转业务实体，但是目前插件市场没有一款插件可以同时支持生成多种语言，导致需要下载很多个插件，很多强迫症患者是无法接受的。

基于这个背景，我开发了这个插件，统一把这些功能集成到一个插件中去
# 二、插件下载以及配置

### 下载

可以直接去插件的开源地址下载Release版本，下载到本地之后IDE本地导入即可。
插件开源地址:[https://github.com/RmondJone/JsonToAnyLanguage](https://github.com/RmondJone/JsonToAnyLanguage)

你也可以直接插件市场搜索JsonToAnyLanguage进行下载

![](http://www.guohanlin.com/images/quicktype_anzhuang.png)

### 插件配置

默认可以不用配置插件，只有当请求QuickTypeNode服务失败时，你可以本地自建QuickTypeNode服务，然后把访问链接配置到设置中

![](http://www.guohanlin.com/images/jsontoanylanguage_setting.png)

# 三、插件的使用以及效果

插件使用上也非常简单，只需在你想要生成代码的目录上右键即可调用起插件菜单，然后在插件弹窗里粘贴Json字符串、选择你想要生成的语言即可

![](http://www.guohanlin.com/images/jsontoanylanguage_action.gif)

# 四、注意事项
如果请求QuickTypeNode服务失败，可以尝试配置以下host

```
104.168.153.3 quicktype.guohanlin.com
```

如果配置Host还是不行，你可以尝试本地搭建QuickTypeNode服务，然后服务地址配置到插件中即可 [QuickTypeNode](https://github.com/RmondJone/QuickTypeNode)

# 五、使用反馈

欢迎加入我的电报群：[https://t.me/YApiQuickType](https://t.me/YApiQuickType)

<img src="http://www.guohanlin.com/images/quicktype_tg_group.jpg" width="300"/>

QQ群：[264587303](https://jq.qq.com/?_wv=1027&k=96R8fd5v)

<img src="http://www.guohanlin.com/images/qq_group.jpg" width="300"/>

如果你使用了YApi，这里推荐另一个更好用的JetBrains插件 [https://github.com/RmondJone/YapiQuickType](https://github.com/RmondJone/YapiQuickType)
