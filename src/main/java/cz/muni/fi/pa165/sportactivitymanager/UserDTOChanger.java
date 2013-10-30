/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportactivitymanager;

/**
 *
 * @author tempest
 */
//TODO
public class UserDTOChanger {
  
    //convert userDTO to Entity User
    public static User dtoToUserEntity(UserDTO userDto) {
        
        if(null == userDto) return null;
        
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setBirthDay(userDto.getBirthDay());
        user.setGender(userDto.getGender());
        user.setWeight(userDto.getWeight());
        return user;
    }

    //convert user to userDTO
    public static UserDTO entityToDTO(User user) {
        if(null == user) return null;
        
        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setBirthDay(user.getBirthDay());
        userDto.setGender(user.getGender());
        userDto.setWeight(user.getWeight());
        return userDto;
    }

    //TODO

}
