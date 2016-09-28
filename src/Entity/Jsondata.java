package Entity;

import java.util.Map;

/**
 * 前台传输json数据的对象
 * 对象数据和非对象数据整合在一起，可以应对对象和非对象数据的各种组合
 */
public class Jsondata<T> {

    //用于存放对象的json数据
    private T jsondata;
    //用于存放非对象的json数据
    private Map<String,Object> map;

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public T getJsondata() {
        return jsondata;
    }

    public void setJsondata(T jsondata) {
        this.jsondata = jsondata;
    }
}
