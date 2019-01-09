package kvl.school.ivh11.repositories.abstr;

import kvl.school.ivh11.domain.ApiUser;

public interface ApiUserRepo extends BaseRepo<ApiUser, Long>
{
    ApiUser getUserByApiKey(String hash);
}
