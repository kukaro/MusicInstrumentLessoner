package hack.the.wap.musicinstrumentlessoner.session;

import hack.the.wap.musicinstrumentlessoner.model.dto.NotificationDto;
import hack.the.wap.musicinstrumentlessoner.model.dto.TemplateDto;
import hack.the.wap.musicinstrumentlessoner.model.dto.UserGroupDto;

public class Session {
    private String mainUser;
    private NotificationDto notification;
    private TemplateDto template;
    private UserGroupDto userGroup;

    public Session() {

    }

    public String getMainUser() {
        return mainUser;
    }

    public void setMainUser(String mainUser) {
        this.mainUser = mainUser;
    }

    public NotificationDto getNotification() {
        return notification;
    }

    public void setNotification(NotificationDto notification) {
        this.notification = notification;
    }

    public TemplateDto getTemplate() {
        return template;
    }

    public void setTemplate(TemplateDto template) {
        this.template = template;
    }

    public UserGroupDto getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroupDto userGroup) {
        this.userGroup = userGroup;
    }
}
