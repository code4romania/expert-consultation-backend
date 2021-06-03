package ro.code4.expertconsultation.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.code4.expertconsultation.user.model.dto.UserDto;
import ro.code4.expertconsultation.user.service.UserService;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable final UUID id,
                                          @RequestBody final UserDto userDto) {
        final UserDto updatedUserDto = userService.update(id, userDto);
        return ResponseEntity.ok(updatedUserDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> get(@PathVariable final UUID id) {
        final UserDto userDto = userService.get(id);
        return ResponseEntity.ok(userDto);
    }
}
