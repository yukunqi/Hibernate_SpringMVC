package Upload.Service;

import Entity.ExpertsInfo;

import java.util.Comparator;

/**
 * 根据好评率降序排序
 */
public class ExpertComparator2 implements Comparator<ExpertsInfo> {
    @Override
    public int compare(ExpertsInfo o1, ExpertsInfo o2) {
        if (o2.getGood_comment()>o1.getGood_comment()){
            return 1;
        }else if (o2.getGood_comment()==o1.getGood_comment()){//如果好评率相等，根据咨询人数排序
            return o2.getConsult_number()-o1.getConsult_number();
        }else {
            return -1;
        }
    }
}
