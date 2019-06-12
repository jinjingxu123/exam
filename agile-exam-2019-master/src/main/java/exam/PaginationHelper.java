
package exam;

import java.util.ArrayList;
import java.util.List;

// TODO: 完成这个类

public class PaginationHelper<I> {

    /**
     * 构造函数包含
     * 1）数组collection，表示需要分页的所有元素
     * 2）数字itemsPerPage，表示每页的元素个数
     */
    private List<I> collection;
    private int itemsPerPage;

    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * 返回collection中所有元素的个数
     */
    public int itemCount() {
        if (collection == null || collection.size() <= 0) {
            throw new RuntimeException();
        }
        return collection.size();
    }

    /**
     * 返回页数
     */
    public int pageCount() {
        if (itemsPerPage == 0) {
            throw new RuntimeException();
        }
        int pageMainCount = collection.size() / itemsPerPage;
        int pageRestCount = collection.size() % itemsPerPage;
        if (pageRestCount > 0) {
            pageMainCount++;
        }
        return pageMainCount;
    }

    /**
     * 返回当前页pageIndex中所包含的元素个数
     * pageIndex从0开始计数
     * 如果pageIndex为非法值则返回-1
     */
    public int pageItemCount(int pageIndex) {
        int len = collection.size()/itemsPerPage;
        if(pageIndex<=len && pageIndex>0){
            int startIndex = pageIndex * itemsPerPage;
            int endIndex = startIndex + itemsPerPage;
            List<I> perList = new ArrayList<I>(collection.subList(startIndex, endIndex));
            return perList.size();
        } else {
            return -1;
        }
    }

    /**
     * 返回第itemIndex个元素所在的页数
     * pageIndex从0开始计数
     * 如果itemIndex为非法值则返回-1
     */

    public int pageIndex(int itemIndex) {
        int len = collection.size();
        if(itemIndex<=len && itemIndex >0){
            return itemIndex / itemsPerPage;
        }else{
            return -1;
        }
    }
}

