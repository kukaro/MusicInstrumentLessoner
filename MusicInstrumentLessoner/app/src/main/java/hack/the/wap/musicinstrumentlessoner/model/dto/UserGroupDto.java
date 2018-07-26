package hack.the.wap.musicinstrumentlessoner.model.dto;

import java.util.ArrayList;

public class UserGroupDto {
    private ArrayList<TeacherDto> teachers;
    private ArrayList<UserDto> users;

    public UserGroupDto() {
        users = new ArrayList<>();
        teachers = new ArrayList<>();
    }

    public ArrayList<UserDto> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserDto> users) {
        this.users = users;
    }

    public ArrayList<TeacherDto> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<TeacherDto> teachers) {
        this.teachers = teachers;
    }
}
