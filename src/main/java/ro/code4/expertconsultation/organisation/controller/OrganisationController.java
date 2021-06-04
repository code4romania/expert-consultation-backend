package ro.code4.expertconsultation.organisation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.code4.expertconsultation.organisation.model.dto.OrganisationDto;
import ro.code4.expertconsultation.organisation.service.OrganisationService;
import ro.code4.expertconsultation.user.model.dto.UserDto;
import ro.code4.expertconsultation.user.service.UserService;

@RestController
@RequestMapping("/api/organisations")
@RequiredArgsConstructor
public class OrganisationController {
    private final OrganisationService organisationService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<OrganisationDto> create(@RequestBody final OrganisationDto organisationDto) {
        final OrganisationDto savedOrganisationDto = organisationService.create(organisationDto);
        return ResponseEntity.ok(savedOrganisationDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganisationDto> update(@PathVariable final Long id,
                                                  @RequestBody final OrganisationDto organisationDto) {
        final OrganisationDto updatedOrganisationDto = organisationService.update(id, organisationDto);
        return ResponseEntity.ok(updatedOrganisationDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganisationDto> get(@PathVariable final Long id) {
        final OrganisationDto organisationDto = organisationService.get(id);
        return ResponseEntity.ok(organisationDto);
    }

    @PostMapping("{id}/users")
    public ResponseEntity<UserDto> addUser(@PathVariable("id") final Long organisationId,
                                           @RequestBody final UserDto userDto) {
        final UserDto savedUserDto = userService.create(organisationId, userDto);
        return ResponseEntity.ok(savedUserDto);
    }
}
