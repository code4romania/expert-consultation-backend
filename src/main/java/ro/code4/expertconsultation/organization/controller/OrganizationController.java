package ro.code4.expertconsultation.organization.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ro.code4.expertconsultation.core.model.dto.PageDto;
import ro.code4.expertconsultation.organization.model.OrganizationFilter;
import ro.code4.expertconsultation.organization.model.dto.OrganizationDto;
import ro.code4.expertconsultation.organization.service.OrganizationService;
import ro.code4.expertconsultation.user.model.dto.UserDto;
import ro.code4.expertconsultation.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationService organizationService;
    private final UserService userService;

    @PostMapping
    public OrganizationDto create(@RequestBody final OrganizationDto organizationDto) {
        return organizationService.create(organizationDto);
    }

    @GetMapping
    public PageDto<OrganizationDto> list(final OrganizationFilter organizationFilter,
                                         final Pageable pageable) {
        final Page<OrganizationDto> organisationDtosPage = organizationService.list(organizationFilter, pageable);
        return new PageDto<>(organisationDtosPage);
    }

    @PutMapping("/{id}")
    public OrganizationDto update(@PathVariable final Long id,
                                  @RequestBody final OrganizationDto organizationDto) {
        return organizationService.update(id, organizationDto);
    }

    @GetMapping("/{id}")
    public OrganizationDto get(@PathVariable final Long id) {
        return organizationService.get(id);
    }

    @PostMapping("{id}/users")
    public UserDto addUser(@PathVariable("id") final Long organisationId,
                           @RequestBody final UserDto userDto) {
        return userService.create(organisationId, userDto);
    }

    @GetMapping("{id}/users")
    public List<UserDto> listUsers(@PathVariable("id") final Long organizationId) {
        return organizationService.listMembers(organizationId);
    }
}
