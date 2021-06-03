package ro.code4.expertconsultation.organisation.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.code4.expertconsultation.organisation.mapper.OrganisationMapper;
import ro.code4.expertconsultation.organisation.model.dto.OrganisationDto;
import ro.code4.expertconsultation.organisation.model.persistence.Organisation;
import ro.code4.expertconsultation.organisation.repository.OrganisationRepository;
import ro.code4.expertconsultation.organisation.service.OrganisationService;
import ro.code4.expertconsultation.user.mapper.UserMapper;
import ro.code4.expertconsultation.user.model.dto.UserDto;
import ro.code4.expertconsultation.user.model.persistence.User;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrganisationServiceImpl implements OrganisationService {
    private final OrganisationRepository organisationRepository;
    private final OrganisationMapper organisationMapper;
    private final UserMapper userMapper;

    @Override
    public OrganisationDto create(final OrganisationDto organisationDto) {
        final Organisation organisation = organisationMapper.map(organisationDto);
        final Organisation savedOrganisation = organisationRepository.save(organisation);
        return organisationMapper.map(savedOrganisation);
    }

    @Override
    public OrganisationDto update(final UUID organisationId, final OrganisationDto organisationDto) {
        final Organisation organisation = organisationRepository.findById(organisationId)
                .orElseThrow(EntityNotFoundException::new);

        organisation.setCategory(organisationDto.getCategory());
        organisation.setName(organisationDto.getName());
        organisation.setEmail(organisationDto.getEmail());
        organisation.setPhoneNumber(organisationDto.getPhoneNumber());
        organisation.setWebsite(organisationDto.getWebsite());
        organisation.setAddress(organisationDto.getAddress());
        organisation.setContactPersonName(organisationDto.getContactPersonName());
        organisation.setContactPersonEmail(organisationDto.getContactPersonEmail());
        organisation.setNumberOfMembers(organisationDto.getNumberOfMembers());

        final Organisation savedOrganisation = organisationRepository.save(organisation);
        return organisationMapper.map(savedOrganisation);
    }

    @Override
    public OrganisationDto get(final UUID organisationId) {
        final Organisation organisation = organisationRepository.findById(organisationId)
                .orElseThrow(EntityNotFoundException::new);
        return organisationMapper.map(organisation);
    }

    @Override
    public List<UserDto> getMembers(final UUID organisationId) {
        final List<User> organisationMembers = organisationRepository.findOrganisationMembers(organisationId);
        return organisationMembers.stream()
                .map(userMapper::map)
                .collect(Collectors.toList());
    }
}
