package bgd.controller.implementations;

import bgd.controller.AbstractController;
import bgd.model.entity.Security;
import bgd.service.implementations.SecurityService;

import java.sql.SQLException;
import java.util.List;

public class SecurityController implements AbstractController<Security> {
    SecurityService service = new SecurityService();

    @Override
    public List<Security> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public void create(Security entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public Security findByLogin(String login) throws SQLException {
        return service.findByLogin(login);
    }

    @Override
    public void update(String login, Security entity) throws SQLException {
        service.update(login, entity);
    }

    @Override
    public void delete(String login) throws SQLException {
        service.delete(login);
    }
}

