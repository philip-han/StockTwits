package code.challenge.stocktwits.model.entity;

import com.squareup.moshi.Json;

/**
 * Created by Philip K. Han on 2/20/18.
 */

public class Link {
  private String title;
  private String url;
  @Json(name = "shortened_expanded_url")
  private String shortenedExpandedUrl;
  private String description;
  private String image;
  @Json(name = "created_at")
  private String createdAt;
  private Source source;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getShortenedExpandedUrl() {
    return shortenedExpandedUrl;
  }

  public void setShortenedExpandedUrl(String shortenedExpandedUrl) {
    this.shortenedExpandedUrl = shortenedExpandedUrl;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public Source getSource() {
    return source;
  }

  public void setSource(Source source) {
    this.source = source;
  }
}
