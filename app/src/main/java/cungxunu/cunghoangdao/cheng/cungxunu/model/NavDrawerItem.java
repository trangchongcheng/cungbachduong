package cungxunu.cunghoangdao.cheng.cungxunu.model;

/**
 * Created by Ravi on 29/07/15.
 */
public class NavDrawerItem {
    private boolean showNotify;
    private String title;
    private int imgDrawer;


    public NavDrawerItem() {

    }

    public NavDrawerItem(String title, int imgDrawer) {
        this.title = title;
        this.imgDrawer = imgDrawer;
    }

    public NavDrawerItem(boolean showNotify, String title) {
        this.showNotify = showNotify;
        this.title = title;
    }

    public boolean isShowNotify() {
        return showNotify;
    }

    public void setShowNotify(boolean showNotify) {
        this.showNotify = showNotify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgDrawer() {
        return imgDrawer;
    }

    public void setImgDrawer(int imgDrawer) {
        this.imgDrawer = imgDrawer;
    }
}
