package kvl.school.ivh11.repository;

import kvl.school.ivh11.domain.ApiUser;

public interface ApiUserRepo extends BaseRepo<ApiUser, Long>
{
    ApiUser getUserByApiKey(String hash);
}
