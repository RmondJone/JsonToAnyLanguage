# 1. Business Background

In daily development, we often use plug-ins to convert JSON to business entities, but at present,
there is no plug-in in the plug-in market that can support generating multiple languages at the same
time, resulting in the need to download many plug-ins, which is unacceptable for many
obsessive-compulsive disorder patients.

Based on this background, I developed this plug-in to integrate these functions into one plug-in.

# 2. Plug-in download and configuration

### Download

You can directly go to the open source address of the plug-in to download the Release version, and
after downloading it locally, the IDE can import it locally. Plug-in open source
address:[https://github.com/RmondJone/JsonToAnyLanguage](https://github.com/RmondJone/JsonToAnyLanguage)

You can also search for JsonToAnyLanguage directly in the plugin market to download

![](http://www.guohanlin.com/images/quicktype_anzhuang.png)

### Plugin configuration

There is no need to configure the plugin by default. Only when the request for the QuickTypeNode
service fails, you can build the QuickTypeNode service locally, and then configure the access link
into the settings.

![](http://www.guohanlin.com/images/jsontoanylanguage_setting.png)

# 3.The use of plug-ins and effects

The plugin is also very simple to use. Just right-click on the directory where you want to generate
code to invoke the plugin menu, then paste the Json string in the plugin pop-up window and select
the language you want to generate.

![](http://www.guohanlin.com/images/jsontoanylanguage_action.gif)

# 4. Matters needing attention

If the request to QuickTypeNode service fails, you can try to configure the following host

```
104.168.153.3 quicktype.guohanlin.com
```

If configuring the Host still doesn't work, you can try to build the QuickTypeNode service locally,
and then configure the service address to the
plugin. [QuickTypeNode](https://github.com/RmondJone/QuickTypeNode)

# 5. Feedback

Welcome to my telegram group:[https://t.me/YApiQuickType](https://t.me/YApiQuickType)

<img src="http://www.guohanlin.com/images/quicktype_tg_group.jpg" width="300"/>

If you use YApi, here is another better plugin for JetBrains [https://github.com/RmondJone/YapiQuickType](https://github.com/RmondJone/YapiQuickType)

[中文文档](./README_CN.md)