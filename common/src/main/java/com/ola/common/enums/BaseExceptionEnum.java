package com.ola.common.enums;


public enum BaseExceptionEnum {
    AUTH_IS_ERROR((byte) 101, "请求参数检验异常"),

    SUCCESS((byte) 200, "成功"),

    SERVER_EXCEPTION((byte) 500, "服务开小差，请稍后重试～"),

    BAD_REQUEST((byte) 999, "非法请求"),

    FAIL((byte) 701, "执行失败！"),

    COLLECTION_ID_NOT_NULL((byte) 702, "素材id不能为空！"),

    COLLECTION_GATHER_ID_NOT_NULL((byte) 703, "素材集id不能为空！"),

    USER_ID_NOT_NULL((byte) 704, "用户id不能为空！"),

    USER_ATTENTION_IS_NULL((byte) 705, "关注用户信息不存在"),

    USER_INFO_IS_NULL((byte) 706, "用户不存在或已停用"),

    SEND_SMS_IS_SOON((byte) 707, "短信验证码发送过于频繁，请稍后再试"),

    SEND_SMS_TODAY_IS_ENOUGH((byte) 708, "短信验证码已达当日发送次数，请明天再试"),

    SEND_SMS_PARAM_NULL((byte) 709, "发送验证码失败，参数不能为空"),

    SEND_SMS_ERROR((byte) 710, "获取短信验证码异常，请联系客服"),

    SMS_IS_EXPIRE((byte) 711, "短信验证码已失效"),

    SMS_IS_ERROR((byte) 712, "短信验证码不正确"),

    PARAM_CHECK_ERROR((byte) 713, "参数签名错误"),

    PARAMETER_NOT_NULL((byte) 714, "输入参数有误！"),

    USER_FANS_IS_NULL((byte) 715, "用户粉丝不存在"),

    IMAGE_SIZE_IS_LARGER((byte) 716, "图片大小超过1M"),

    AUDIO_SIZE_IS_LARGER((byte) 717, "音频大小不能超过20M"),

    FEEDBACK_IS_NULL((byte) 718, "反馈信息不存在"),

    MATERIAL_IS_SHARE((byte) 719, "素材已分享"),

    APPLET_AUTH_NULL((byte) 720, "获取微信授权信息失败"),

    AUTH_INFO_NULL((byte) 721, "获取微信用户信息异常"),

    TELEPHONE_IS_USED((byte) 722, "手机号已被用户绑定"),

    DATE_FORMAT_WRONG((byte) 723, "日期格式有误"),

    NAVIGATION_ID_NOT_NULL((byte) 724, "id不能为空！"),

    NAVIGATION_AD_LINKS_NOT_NULL((byte) 725, "广告链接不能为空！"),

    CATEGORY_ID_NOT_NULL((byte) 725, "分类选择不能为空！");

    private Byte code;

    private String desc;

    BaseExceptionEnum(Byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static int getCode(String message) {
        int code = 200;
        for (BaseExceptionEnum baseExceptionEnum : BaseExceptionEnum.values()) {
            if (baseExceptionEnum.desc.equalsIgnoreCase(message)) {
                code = baseExceptionEnum.code;
                break;
            }
        }
        return code;
    }

    public Byte getCode() {
        return code;
    }

    public void setCode(Byte code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
