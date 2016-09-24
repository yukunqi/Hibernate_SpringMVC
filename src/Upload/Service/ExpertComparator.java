package Upload.Service;

import Entity.ExpertsInfo;

import java.util.Comparator;

/**
 * 根据老师的好评率和咨询人数综合排序
 */
public class ExpertComparator implements Comparator<ExpertsInfo> {

    @Override
    public int compare(ExpertsInfo o1, ExpertsInfo o2) {
        double result1,result2;
        result1=o1.getConsult_number()*0.5+o1.getGood_comment();
        result2=o2.getConsult_number()*0.5+o2.getGood_comment();
        if (result2>result1){
            return 1;
        }else if(result2==result1){//如果综合的值相等则按照咨询人数排序
            return o2.getConsult_number()-o1.getConsult_number();
        }else {
            return -1;
        }
    }
}
