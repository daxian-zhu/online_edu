jwt生产证书
keytool -genkeypair -alias kevin_key -keyalg RSA -keypass daxianzuishuai -keystore kevin_key.jks -storepass daxianzuishuai
查看证书信息
keytool -list -v -keystore kevin_key.jks -storepass daxianzuishuai
查看公钥
keytool -list -rfc -keystore kevin_key.jks -storepass daxianzuishuai

测试地址：
http://localhost:9004/oauth/authorize?response_type=code&client_id=daxian&redirect_uri=https://www.baidu.com