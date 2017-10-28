package com.kncorp.project;

import com.sun.xml.internal.ws.client.RequestContext;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.security.Principal;
import java.util.List;

@Named
@SessionScoped
public class UserController implements Serializable {
    @Inject
    private UserEJB userEJB;

    @Inject
    private Order order;


    private String login;
    private String password;

    private User user;

    public String signin(){

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        System.out.println(login+"  "+ password);
        System.out.println(request.getSession().getId());
        try {
            request.login(login,password);
        } catch (ServletException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Login failed!",null));
            return "login";
        }

        Principal principal = request.getUserPrincipal();
        System.out.println(principal.getName());
        this.user = userEJB.findUserByLogin(principal.getName());

        if (request.isUserInRole("private"))
            return "/private/index?faces-redirect=true";
        else if (request.isUserInRole("public")){
            return "/public/index?faces-redirect=true";
        } else return "login";
    }

    public String singout(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        try{
            this.user=null;
            request.logout();

            ((HttpSession) context.getExternalContext().getSession(false)).invalidate();
        } catch (ServletException e) {

        }

        return "/login?faces-redirect=true";
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void method()
    {

        FacesContext currentInstance = FacesContext.getCurrentInstance();
        List<UIComponent> children = currentInstance.getViewRoot().getChildren();

        for (UIComponent component : children){
            String id = component.getId();
            String rendererType = component.getRendererType();
            System.out.println("AAAAAAAAAAAAAAAAZZZZZZZZZZZIIIIIIIIIAAAAAAAATTTTTTTT {PIDAR  "+id+" ff "+rendererType);
        }

        HtmlPanelGrid panelGrid = new HtmlPanelGrid();

    }
}
