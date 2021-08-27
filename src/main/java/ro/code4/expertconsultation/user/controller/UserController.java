package ro.code4.expertconsultation.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.code4.expertconsultation.authentication.model.CurrentUser;
import ro.code4.expertconsultation.user.model.dto.UserDto;
import ro.code4.expertconsultation.user.service.UserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PutMapping("/{id}")
    public UserDto update(@PathVariable final Long id,
                          @RequestBody final UserDto userDto) {
        return userService.update(id, userDto);
    }

    @GetMapping("/{id}")
    public UserDto get(@PathVariable final Long id) {
        return userService.get(id);
    }
}
