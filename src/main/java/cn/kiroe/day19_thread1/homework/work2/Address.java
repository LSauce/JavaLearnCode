package cn.kiroe.day19_thread1.homework.work2;

import java.io.Serializable;

/**
 * @author kiro
 * @description:
 * @data 19:13 3/11/2023
 **/
public class Address implements Serializable {
    private static final long serialVersionUID = -1184610770003271892L;
    private String detail;
    private String code;

    public Address(String detail, String code) {

        this.detail = detail;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Address{" +
                "detail='" + detail + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
