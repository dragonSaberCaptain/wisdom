package com.jskj.wisdom.model.mongodb;

import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.model.mongodb
 * @description
 * @date 2018-05-17 16:47 Thu
 */
public class MongodbUser {
    private IdBean          _id;
    private String          caretype;
    private String          country;
    private String          national;
    private String          phone;
    private String          sex;
    private String          zjtype;
    private boolean         down;
    private boolean         web;
    private int             status;
    private String          zjnum;
    private String          name;
    private String          img;
    private int             time;
    private List<RoomsBean> rooms;

    public IdBean get_id() {
        return _id;
    }

    public void set_id(IdBean _id) {
        this._id = _id;
    }

    public String getCaretype() {
        return caretype;
    }

    public void setCaretype(String caretype) {
        this.caretype = caretype;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getZjtype() {
        return zjtype;
    }

    public void setZjtype(String zjtype) {
        this.zjtype = zjtype;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isWeb() {
        return web;
    }

    public void setWeb(boolean web) {
        this.web = web;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getZjnum() {
        return zjnum;
    }

    public void setZjnum(String zjnum) {
        this.zjnum = zjnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public List<RoomsBean> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomsBean> rooms) {
        this.rooms = rooms;
    }

    public static class IdBean {
        /**
         * $oid : 5af3cb7671491333d47ff5e9
         */

        private String $oid;

        public String get$oid() {
            return $oid;
        }

        public void set$oid(String $oid) {
            this.$oid = $oid;
        }
    }

    public static class RoomsBean {
        /**
         * buildingnum : 4
         * unitnum : 1
         * roomnum : 1503
         * livetype : 租住
         */

        private int    buildingnum;
        private int    unitnum;
        private int    roomnum;
        private String livetype;

        public int getBuildingnum() {
            return buildingnum;
        }

        public void setBuildingnum(int buildingnum) {
            this.buildingnum = buildingnum;
        }

        public int getUnitnum() {
            return unitnum;
        }

        public void setUnitnum(int unitnum) {
            this.unitnum = unitnum;
        }

        public int getRoomnum() {
            return roomnum;
        }

        public void setRoomnum(int roomnum) {
            this.roomnum = roomnum;
        }

        public String getLivetype() {
            return livetype;
        }

        public void setLivetype(String livetype) {
            this.livetype = livetype;
        }
    }
}
