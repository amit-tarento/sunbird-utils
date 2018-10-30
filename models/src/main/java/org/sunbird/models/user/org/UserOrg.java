package org.sunbird.models.user.org;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserOrg implements Serializable {
  private static final long serialVersionUID = 1L;
  
  private String id;
  private String addedBy;
  private String addedByName;
  private String approvalDate;
  private String approvedBy;
  private String hashTagId;
  private boolean isApproved;
  private boolean isDeleted;
  private boolean isRejected;
  private String organisationId;
  private String orgJoinDate;
  private String orgLeftDate;
  private String position;
  private List<String> roles;
  private String updatedBy;
  private String updatedDate;
  private String userId;

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAddedBy() {
    return addedBy;
  }

  public void setAddedBy(String addedBy) {
    this.addedBy = addedBy;
  }

  public String getAddedByName() {
    return addedByName;
  }

  public void setAddedByName(String addedByName) {
    this.addedByName = addedByName;
  }

  public String getApprovalDate() {
    return approvalDate;
  }

  public void setApprovalDate(String approvalDate) {
    this.approvalDate = approvalDate;
  }

  public String getApprovedBy() {
    return approvedBy;
  }

  public void setApprovedBy(String approvedBy) {
    this.approvedBy = approvedBy;
  }

  public String getHashTagId() {
    return hashTagId;
  }

  public void setHashTagId(String hashTagId) {
    this.hashTagId = hashTagId;
  }

  public boolean isApproved() {
    return isApproved;
  }

  public void setApproved(boolean isApproved) {
    this.isApproved = isApproved;
  }

  public boolean isDeleted() {
    return isDeleted;
  }

  public void setDeleted(boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  public boolean isRejected() {
    return isRejected;
  }

  public void setRejected(boolean isRejected) {
    this.isRejected = isRejected;
  }

  public String getOrganisationId() {
    return organisationId;
  }

  public void setOrganisationId(String organisationId) {
    this.organisationId = organisationId;
  }

  public String getOrgJoinDate() {
    return orgJoinDate;
  }

  public void setOrgJoinDate(String orgJoinDate) {
    this.orgJoinDate = orgJoinDate;
  }

  public String getOrgLeftDate() {
    return orgLeftDate;
  }

  public void setOrgLeftDate(String orgLeftDate) {
    this.orgLeftDate = orgLeftDate;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

  public String getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }

  public String getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(String updatedDate) {
    this.updatedDate = updatedDate;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

}