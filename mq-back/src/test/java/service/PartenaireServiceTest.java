package service;

import org.bank.MqApplication;
import org.bank.entity.Partenaire;
import org.bank.repository.PartenaireRepository;
import org.bank.service.PartenaireService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MqApplication.class)
@ActiveProfiles("test")
class PartenaireServiceTest {

    @Mock
    private PartenaireRepository partenaireRepository;

    @InjectMocks
    private PartenaireService partenaireService;

    @Test
    void shouldReturnAllPartenaires() {
        List<Partenaire> partenaires = List.of(new Partenaire(1L, "alias1", "type", Partenaire.Direction.INBOUND, "app", Partenaire.ProcessedFlowType.MESSAGE, "desc"));
        when(partenaireRepository.findAll()).thenReturn(partenaires);

        List<Partenaire> result = partenaireService.findAll();
        assertEquals(1, result.size());
    }

    @Test
    void shouldSavePartenaire() {
        Partenaire partenaire = new Partenaire(null, "alias", "type", Partenaire.Direction.INBOUND, "app", Partenaire.ProcessedFlowType.MESSAGE, "desc");
        Partenaire saved = new Partenaire(1L, "alias", "type", Partenaire.Direction.INBOUND, "app", Partenaire.ProcessedFlowType.MESSAGE, "desc");

        when(partenaireRepository.save(partenaire)).thenReturn(saved);
        Partenaire result = partenaireService.save(partenaire);

        assertNotNull(result.getId());
        assertEquals("alias", result.getAlias());
    }
}

