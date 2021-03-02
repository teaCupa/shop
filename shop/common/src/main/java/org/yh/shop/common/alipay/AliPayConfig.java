package org.yh.shop.common.alipay;

/**
 * @Author: yh
 * @Date: 2020/12/5
 * @Description:   沙盒支付显示页面钓鱼->关闭支付宝页面，删除缓存
 */


public interface AliPayConfig {
    public final String APP_ID = "2021000116660478";
    public final String APP_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCW804b21KdOXYPeJ1IKhsFFUMbyVJ5TzwuAiWFHm5PLqggARjJVWvEQN27NQTkQRle3PRzrzBxw3TVfnA2qYzm2BAkajI4EdeznjgqfFghWj5XhU3Wt2PuOjPElnX4ARmmV0Fu7ogeVCvjM1uuR0Pl8NZvq4uMM0FVlgOMAKUcsYUHwS0UpyYFp6V67bV6R1lcaqG97P2ruk608HJD1I4ugoEZTwNIZA1vdVO0c0AaVBUtD5f9+KDnIEorG1jjczjKO1bxhPvPd6tJighCQ73/44QCjq+PFt8DJs/zybv4MdfWowFFnlhskrtv8JY5gkidmnJJRu1tEKL/4S04qew7AgMBAAECggEAJqPRcsAJvcVfu0YcvMRKdlqi+xHl0re9p+lUwWawxgQjdU3SkncTRwFzwOApiGRBok7dJF/L/tMRrTTYdKWiM9VLDIdCo6etl4UAy59Yz/DR1IWDD1uScQDlD4WUXQ+rCTF8xnC410qkkVwsM8h6UPn9akh3SEQ2jToBXm0r1tQVa1eZ+8mZDOFP6+QUdzs+ksfo56FxqAyoA/xXjteW8MwzxtRRN/2ZtPSe/eKmbG7Y6y/L5lkXc7OZKZBQHa0aUyHNmDy5R9p/afv3ZQFme0ZRbuko2VVqWQL70BoDtUqBYBKV6OsiJEEe3Wo71oNgWzr3pt84AIFcTuwifPtZgQKBgQDROUrphN0NRyeMhQzxZaAtjjCCan8XpVajGiqhI5Yx/SC2shmORGDO6KzwrvQrU8Ga/uJ3t509dA8WwZ1Jf+e8s7GtRS+uqSsE0Q2ibjAmH0WGypU9WfNObImNqc6ljDc/rX59mLOyYYCUFZxA3g3I1ZaQ9ReE/vGM5FROId+ZMwKBgQC4ssujV5QQWAo3xF/3jCxFWaoigciVbg9vSaVKLg0yMRcCJaafrXoAWWUTgnr8njSjiL+DTzFOAzI1xl9FQaY4VJzwsS5Vv1Q6+PvTzpIi2q8hZXhpgHz+HgpyOBF99JzboZMG22mvsmRD8RSWx8BT2qR+DOh/Q194f8VAH/qw2QKBgDcWxsrF2Q5t9dPiFI5bG9ni3pL4R46KUk2PzjmvjRSMedig/GmhR3wzd5XH+zKNUyTkh+zNw/EyZeawBCIeM35UMixVU0DB+jnCcbybFsJy6XOcU79bt9ymZ3GNjIO6b7GslOmtE2OcmKZlKkdKMIb49jQk1JSILEHUvP31nVJRAoGAWODpL4woWwkSua1NBQG2GBVC0uIjVQ0mbkZBPQYWIY4P5V+a5AIF0H80LYQ/jKrQ59UZW6XTMxhEpC32kIw74aWN9CE/C9JLRSmlfVJNbmpPlkGPBS3oeByaqEYk3LjGdsY0yzrwi7TLnQo4/ynWekOfnmy1wO/51DGgCPCaoVkCgYBZN677Cp1WJdGBMxIL1mir75u3QxT3u7uETT9K7QlQWt2HpbFarcQPVL60TpzuvpteKXlyW4+hE3DZvH5jXIIvFKZFnqq3NKu2zNlX8OWJHRgbzDX14HdqozxSaP/SZ52vUN362IKMO7fk9YQHqoI0Fal7sAD82V7kqsF1rXpARw==";

    public final String CHARSET = "UTF-8";
    public final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlvNOG9tSnTl2D3idSCobBRVDG8lSeU88LgIlhR5uTy6oIAEYyVVrxEDduzUE5EEZXtz0c68wccN01X5wNqmM5tgQJGoyOBHXs544KnxYIVo+V4VN1rdj7jozxJZ1+AEZpldBbu6IHlQr4zNbrkdD5fDWb6uLjDNBVZYDjAClHLGFB8EtFKcmBaeleu21ekdZXGqhvez9q7pOtPByQ9SOLoKBGU8DSGQNb3VTtHNAGlQVLQ+X/fig5yBKKxtY43M4yjtW8YT7z3erSYoIQkO9/+OEAo6vjxbfAybP88m7+DHX1qMBRZ5YbJK7b/CWOYJInZpySUbtbRCi/+EtOKnsOwIDAQAB";
    //这是沙箱接口路径,正式路径为https://openapi.alipay.com/gateway.do
    public final String GATEWAY_URL ="https://openapi.alipaydev.com/gateway.do";
    public final String FORMAT = "JSON";
    //签名方式
    public final String SIGN_TYPE = "RSA2";
    //支付宝异步通知路径,付款完毕后会异步调用本项目的方法,必须为公网地址
    public final String NOTIFY_URL = "http://127.0.0.1/notifyUrl";
    //支付宝同步通知路径,也就是当付款完毕后跳转本项目的页面,可以不是公网地址
    public final String RETURN_URL = "http://127.0.0.1/returnUrl";
}
