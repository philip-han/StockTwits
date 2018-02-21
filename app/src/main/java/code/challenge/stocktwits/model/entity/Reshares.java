package code.challenge.stocktwits.model.entity;

import com.squareup.moshi.Json;

import java.util.List;

/**
 * Created by Philip K. Han on 2/20/18.
 */

public class Reshares {
  @Json(name = "reshared_count")
  private int resharedCount;
  @Json(name = "user_ids")
  private List<Long> userIds;
}
