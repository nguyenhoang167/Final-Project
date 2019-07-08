package vn.edu.vnuk.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.edu.vnuk.ecommerce.model.OauthAccessToken;

@Repository
public interface OauthAccessTokenRepository extends CrudRepository<OauthAccessToken, Long> {

    OauthAccessToken getByAccessToken(String accessToken);
}