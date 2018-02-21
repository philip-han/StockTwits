package code.challenge.stocktwits.model.entity;

import com.squareup.moshi.Json;

import java.util.List;

/**
 * Created by Philip K. Han on 2/20/18.
 */

public class Message {
  private long id;
  private String body;
  @Json(name = "created_at")
  private String createdAt;
  private User user;
  private List<Symbol> symbols;
  private Conversation conversation;
  private Reshares reshares;
  @Json(name = "mentioned_users")
  private List<String> mentionedUsers;
  private Entities entities;
  private List<Link> links;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Symbol> getSymbols() {
    return symbols;
  }

  public void setSymbols(List<Symbol> symbols) {
    this.symbols = symbols;
  }

  public Conversation getConversation() {
    return conversation;
  }

  public void setConversation(Conversation conversation) {
    this.conversation = conversation;
  }

  public Reshares getReshares() {
    return reshares;
  }

  public void setReshares(Reshares reshares) {
    this.reshares = reshares;
  }

  public List<String> getMentionedUsers() {
    return mentionedUsers;
  }

  public void setMentionedUsers(List<String> mentionedUsers) {
    this.mentionedUsers = mentionedUsers;
  }

  public Entities getEntities() {
    return entities;
  }

  public void setEntities(Entities entities) {
    this.entities = entities;
  }

  public List<Link> getLinks() {
    return links;
  }

  public void setLinks(List<Link> links) {
    this.links = links;
  }
}
