package com.wxq.developtools.model;

public class OrderBean {


    /**
     * createTime :
     * flowNum :
     * id :
     * num :
     * orderDate :
     * productId :
     * productName :
     * productPackageId :
     * productPackageName :
     * ticketType :
     */

    public String createTime;
    public String flowNum;
    public String id;
    public String num;
    public String orderDate;
    public String productId;
    public String productName;
    public String productPackageId;
    public String productPackageName;
    public String ticketType;
    public String pic="";

    public String getTicketDescribe() {
        if (ticketType.equals("1")){
            return "成人"+num;
        }else {
            return "儿童"+num;
        }

    }
}