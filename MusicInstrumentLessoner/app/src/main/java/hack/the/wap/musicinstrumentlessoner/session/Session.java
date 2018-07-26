package hack.the.wap.musicinstrumentlessoner.session;

import android.os.Debug;

import java.util.ArrayList;

import hack.the.wap.musicinstrumentlessoner.debug.DebugMode;
import hack.the.wap.musicinstrumentlessoner.model.dto.NotificationDto;
import hack.the.wap.musicinstrumentlessoner.model.dto.TemplateDto;
import hack.the.wap.musicinstrumentlessoner.model.dto.UserDto;
import hack.the.wap.musicinstrumentlessoner.model.dto.UserGroupDto;

public class Session {
    private static Session instance;
    private UserDto mainUser;
    private ArrayList<NotificationDto> notifications;
    private ArrayList<TemplateDto> templates;
    private ArrayList<UserGroupDto> userGroups;

    private Session() {
    }

    public UserDto getMainUser() {
        return mainUser;
    }

    public void setMainUser(UserDto mainUser) {
        this.mainUser = mainUser;
    }

    public ArrayList<NotificationDto> getNotifications() {
        return notifications;
    }

    public void setNotifications(ArrayList<NotificationDto> notifications) {
        this.notifications = notifications;
    }

    public ArrayList<TemplateDto> getTemplates() {
        return templates;
    }

    public void setTemplates(ArrayList<TemplateDto> templates) {
        this.templates = templates;
    }

    public ArrayList<UserGroupDto> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(ArrayList<UserGroupDto> userGroups) {
        this.userGroups = userGroups;
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }
}
