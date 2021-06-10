package ro.code4.expertconsultation.organization.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.code4.expertconsultation.organization.mapper.OrganizationMapper;
import ro.code4.expertconsultation.organization.model.OrganizationFilter;
import ro.code4.expertconsultation.organization.model.dto.OrganizationDto;
import ro.code4.expertconsultation.organization.model.persistence.Organization;
import ro.code4.expertconsultation.organization.repository.OrganizationRepository;
import ro.code4.expertconsultation.organization.service.OrganizationService;
import ro.code4.expertconsultation.user.mapper.UserMapper;
import ro.code4.expertconsultation.user.model.dto.UserDto;
import ro.code4.expertconsultation.user.model.persistence.User;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static ro.code4.expertconsultation.organization.repository.OrganizationPredicateFactory.byFilter;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;
    private final UserMapper userMapper;

    @Transactional
    @Override
    public OrganizationDto create(final OrganizationDto organizationDto) {
        final Organization organization = organizationMapper.map(organizationDto);
        final Organization savedOrganization = organizationRepository.save(organization);
        return organizationMapper.map(savedOrganization);
    }

    @Transactional
    @Override
    public OrganizationDto update(final Long organizationId, final OrganizationDto organizationDto) {
        final Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow(EntityNotFoundException::new);

        organization.setCategory(organizationDto.getCategory());
        organization.setName(organizationDto.getName());
        organization.setEmail(organizationDto.getEmail());
        organization.setPhoneNumber(organizationDto.getPhoneNumber());
        organization.setWebsite(organizationDto.getWebsite());
        organization.setAddress(organizationDto.getAddress());
        organization.setContactPersonName(organizationDto.getContactPersonName());
        organization.setContactPersonEmail(organizationDto.getContactPersonEmail());
        organization.setNumberOfMembers(organizationDto.getNumberOfMembers());

        final Organization savedOrganization = organizationRepository.save(organization);
        return organizationMapper.map(savedOrganization);
    }

    @Transactional(readOnly = true)
    @Override
    public OrganizationDto get(final Long organizationId) {
        final Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow(EntityNotFoundException::new);
        return organizationMapper.map(organization);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<OrganizationDto> list(final OrganizationFilter organizationFilter, final Pageable pageable) {
        final Page<Organization> organizationsPage = organizationRepository
                .findAll(byFilter(organizationFilter), pageable);
        return organizationsPage.map(organizationMapper::map);
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserDto> listMembers(final Long organizationId) {
        final List<User> organizationMembers = organizationRepository.findOrganizationMembers(organizationId);
        return organizationMembers.stream()
                .map(userMapper::map)
                .collect(Collectors.toList());
    }
}
