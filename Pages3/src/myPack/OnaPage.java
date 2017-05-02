package myPack;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Laptop on 2017-02-28.
 */
@ManagedBean
@SessionScoped
public class OnaPage {
    private List<Page> pages;
    private Page page;

    public OnaPage() {
        System.out.println("start!");
        Page[] p = {new Page("Sida 1","index?faces-redirect=true"), new Page("Sida 2","page2?faces-redirect=true"), new Page("Sida 3","page3?faces-redirect=true")};
        this.pages = Arrays.asList(p);
        this.page = pages.get(0);
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getName(){
        System.out.println("name me " + getPage().getName());
        return getPage().getName();
    }

    public String next(){
        setPage(pages.get(pages.indexOf(getPage()) +1));
        System.out.println(getPage().getName());
        return getPage().getPath();

    }

    public String prev() {
        setPage(pages.get(pages.indexOf(getPage()) -1));
        System.out.println(getPage().getName());
        return getPage().getPath();
    }
}
