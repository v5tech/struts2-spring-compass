package net.aimeizi.utils;

import org.compass.gps.CompassGps;
import org.springframework.beans.factory.InitializingBean;

public class CompassIndexBuilder implements InitializingBean {

    private boolean buildIndex = false;

    private int lazyTime = 10;

    private CompassGps compassGps;

    private Thread threadIndex = new Thread() {

        @Override
        public void run() {
            try {
                Thread.sleep(lazyTime * 1000);
                System.out.println("开始创建索引......");
                long startTime = System.currentTimeMillis();
                compassGps.index();
                long endTime = System.currentTimeMillis();
                System.out.println("索引创建结束......");
                System.out.println("本次创建索引共花费了" + (endTime - startTime) / 1000 + "秒");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public void afterPropertiesSet() throws Exception {
        if (buildIndex) {
            threadIndex.setDaemon(true);
            threadIndex.setName("Compass index");
            threadIndex.start();
        }

    }

    public boolean isBuildIndex() {
        return buildIndex;
    }

    public void setBuildIndex(boolean buildIndex) {
        this.buildIndex = buildIndex;
    }

    public int getLazyTime() {
        return lazyTime;
    }

    public void setLazyTime(int lazyTime) {
        this.lazyTime = lazyTime;
    }

    public CompassGps getCompassGps() {
        return compassGps;
    }

    public void setCompassGps(CompassGps compassGps) {
        this.compassGps = compassGps;
    }


}
