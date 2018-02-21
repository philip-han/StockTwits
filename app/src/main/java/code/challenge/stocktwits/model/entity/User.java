package code.challenge.stocktwits.model.entity;

import com.squareup.moshi.Json;

/**
 * Created by Philip K. Han on 2/20/18.
 */

public class User {
  private long id;
  private String username;
  private String name;
  @Json(name = "avatar_url")
  private String avatarUrl;
  @Json(name = "avatar_url_ssl")
  private String avatarUrlSsl;
  @Json(name = "join_date")
  private String joinDate;
  private boolean official;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  public String getAvatarUrlSsl() {
    return avatarUrlSsl;
  }

  public void setAvatarUrlSsl(String avatarUrlSsl) {
    this.avatarUrlSsl = avatarUrlSsl;
  }

  public String getJoinDate() {
    return joinDate;
  }

  public void setJoinDate(String joinDate) {
    this.joinDate = joinDate;
  }

  public boolean isOfficial() {
    return official;
  }

  public void setOfficial(boolean official) {
    this.official = official;
  }
}
