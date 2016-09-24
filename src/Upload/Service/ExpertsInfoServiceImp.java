package Upload.Service;

import Entity.ExpertsInfo;
import Upload.DAO.expertInfoDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * 处理咨询列表的service
 */
@Service
public class ExpertsInfoServiceImp implements ExpertInfoService {

    @Autowired
    private  expertInfoDAO expertsInfoDAO;

    public List<ExpertsInfo> expertsInfoList(String type){
        switch (type) {
            case "1":
                return expertsInfoList1();
            case "2":
                return expertsInfoList2();
            case "3":
                return expertsInfoList3();
            default:
                return new ArrayList<>();
        }
    }

    /**
     * 按照咨询人数降序排序
     * @return
     */
    public List<ExpertsInfo> expertsInfoList1(){
        return expertsInfoDAO.query_experts_list();
    }

    /**
     * 按照好评率进行降序排序
     * @return
     */
    public  List<ExpertsInfo> expertsInfoList2(){
        return sort1(expertsInfoDAO.query_experts_list());
    }

    /**
     * 热门推荐，按照好评率和咨询人数权重各百分之50进行降序排序
     * 具体的推荐算法设计以后可以更加专业
     * @return
     */
    public  List<ExpertsInfo> expertsInfoList3(){
        return sort2(expertsInfoDAO.query_experts_list());
    }

    /**
     * 利用java自带的Comparable<T>接口实现排序，在需要排序的对象属性上进行
     * 重写compareTO方法
     * @param list
     * @return
     */
    public List<ExpertsInfo> sort1(List<ExpertsInfo> list){
        Collections.sort(list,new ExpertComparator2());
        return list;
    }

    //要使用springJunitTestrunner来测试才行，否则不会加载spring的注入
    @Test
    public void Test(){
        List<ExpertsInfo> list = expertsInfoDAO.query_experts_list();
        for (ExpertsInfo e:list){
            System.out.println(e.getConsult_number());
        }
    }

    /**
     * 根据老师的好评率和咨询人数综合排序
     * @param list
     * @return
     */
    public List<ExpertsInfo> sort2(List<ExpertsInfo> list){
        Collections.sort(list,new ExpertComparator());
        return list;
    }
}
