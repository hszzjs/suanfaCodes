package com.company.nowLeetCode;

import com.company.basicStructrue.Point;

public class Code_03_maxPoints {
    /**
     * 这个也佛了，复杂度是没有更好的了，但是问题在于所有的边界条件都考虑了，但是为什么最后有一个testCase过不去呢？
     * @param points
     * @return
     */
    public static int maxPoints(Point[] points){
        if (points==null || points.length==0) return 0;
        if (points.length<3) return points.length;
        int res=0;
        for (int i=0;i<points.length;i++){
            for (int j=i+1;j<points.length;j++){
                int temp=0;
                double x1=points[i].x;
                double x2=points[j].x;
                double y1=points[i].y;
                double y2=points[j].y;
                for (int t=0;t<points.length;t++){
                    double x=points[t].x;
                    if (x2==x1) {
                        if (x2 == x)
                            temp++;
                    }else {
                        if (points[t].y ==(int)( (y2 - y1) / (x2 - x1) * (x - x1)) + points[i].y)
                            temp++;
                    }
                }
                res=Math.max(res,temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Point[] points=new Point[]{new Point(3,10),new Point(0,2),new Point(0,2),new Point(3,10)};
        System.out.println(maxPoints(points));
    }
}
