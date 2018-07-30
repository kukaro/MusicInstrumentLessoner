package hack.the.wap.musicinstrumentlessoner.model.dto;

import java.util.ArrayList;
import java.util.HashMap;

public class UserGroupDto {
    private String name;
    private HashMap<String, TeacherDto> teachers;
    private HashMap<String, UserDto> users;

    public UserGroupDto(String name) {
        this.name = name;
        users = new HashMap<>();
        teachers = new HashMap<>();
    }

    public HashMap<String, UserDto> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, UserDto> users) {
        this.users = users;
    }

    public HashMap<String, TeacherDto> getTeachers() {
        return teachers;
    }

    public void setTeachers(HashMap<String, TeacherDto> teachers) {
        this.teachers = teachers;
    }

    public void addTeacher(TeacherDto dto) {
        teachers.put(dto.getName(), dto);
    }

    public void addUser(UserDto dto) {
        users.put(dto.getName(), dto);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserGroupDto{" +
                "teachers=" + teachers +
                ", users=" + users +
                '}';
    }
}
