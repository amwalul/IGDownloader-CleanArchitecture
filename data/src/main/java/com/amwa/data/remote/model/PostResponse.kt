/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.data.remote.model


import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("graphql")
    val graphql: Graphql? = null
)

data class Graphql(
    @SerializedName("shortcode_media")
    val shortcodeMedia: ShortcodeMedia? = null
)

data class ShortcodeMedia(
    @SerializedName("__typename")
    val typename: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("shortcode")
    val shortcode: String? = null,
    @SerializedName("dimensions")
    val dimensions: Dimensions? = null,
    @SerializedName("gating_info")
    val gatingInfo: Any? = null,
    @SerializedName("fact_check_overall_rating")
    val factCheckOverallRating: Any? = null,
    @SerializedName("fact_check_information")
    val factCheckInformation: Any? = null,
    @SerializedName("sensitivity_friction_info")
    val sensitivityFrictionInfo: Any? = null,
    @SerializedName("media_overlay_info")
    val mediaOverlayInfo: Any? = null,
    @SerializedName("media_preview")
    val mediaPreview: String? = null,
    @SerializedName("display_url")
    val displayUrl: String? = null,
    @SerializedName("display_resources")
    val displayResources: List<DisplayResource>? = null,
    @SerializedName("accessibility_caption")
    val accessibilityCaption: String? = null,
    @SerializedName("dash_info")
    val dashInfo: DashInfo? = null,
    @SerializedName("has_audio")
    val hasAudio: Boolean? = null,
    @SerializedName("video_url")
    val videoUrl: String? = null,
    @SerializedName("video_view_count")
    val videoViewCount: Int? = null,
    @SerializedName("video_play_count")
    val videoPlayCount: Any? = null,
    @SerializedName("is_video")
    val isVideo: Boolean? = null,
    @SerializedName("tracking_token")
    val trackingToken: String? = null,
    @SerializedName("edge_media_to_tagged_user")
    val mediaToTaggedUser: MediaToTaggedUser? = null,
    @SerializedName("edge_media_to_caption")
    val mediaToCaption: MediaToCaption? = null,
    @SerializedName("caption_is_edited")
    val captionIsEdited: Boolean? = null,
    @SerializedName("has_ranked_comments")
    val hasRankedComments: Boolean? = null,
    @SerializedName("edge_media_to_parent_comment")
    val mediaToParentComment: MediaToParentComment? = null,
    @SerializedName("edge_media_to_hoisted_comment")
    val mediaToHoistedComment: MediaToHoistedComment? = null,
    @SerializedName("edge_media_preview_comment")
    val mediaPreviewComment: MediaPreviewComment? = null,
    @SerializedName("comments_disabled")
    val commentsDisabled: Boolean? = null,
    @SerializedName("commenting_disabled_for_viewer")
    val commentingDisabledForViewer: Boolean? = null,
    @SerializedName("taken_at_timestamp")
    val takenAtTimestamp: Int? = null,
    @SerializedName("edge_media_preview_like")
    val mediaPreviewLike: MediaPreviewLike? = null,
    @SerializedName("edge_media_to_sponsor_user")
    val mediaToSponsorUser: MediaToSponsorUser? = null,
    @SerializedName("location")
    val location: Location? = null,
    @SerializedName("viewer_has_liked")
    val viewerHasLiked: Boolean? = null,
    @SerializedName("viewer_has_saved")
    val viewerHasSaved: Boolean? = null,
    @SerializedName("viewer_has_saved_to_collection")
    val viewerHasSavedToCollection: Boolean? = null,
    @SerializedName("viewer_in_photo_of_you")
    val viewerInPhotoOfYou: Boolean? = null,
    @SerializedName("viewer_can_reshare")
    val viewerCanReshare: Boolean? = null,
    @SerializedName("owner")
    val owner: Owner? = null,
    @SerializedName("is_ad")
    val isAd: Boolean? = null,
    @SerializedName("edge_web_media_to_related_media")
    val webMediaToRelatedMedia: WebMediaToRelatedMedia? = null,
    @SerializedName("edge_sidecar_to_children")
    val sidecarToChildren: SidecarToChildren? = null,
    @SerializedName("encoding_status")
    val encodingStatus: Any? = null,
    @SerializedName("is_published")
    val isPublished: Boolean? = null,
    @SerializedName("product_type")
    val productType: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("video_duration")
    val videoDuration: Double? = null,
    @SerializedName("thumbnail_src")
    val thumbnailSrc: String? = null,
    @SerializedName("clips_music_attribution_info")
    val clipsMusicAttributionInfo: Any? = null,
    @SerializedName("edge_related_profiles")
    val relatedProfiles: RelatedProfiles? = null
)

data class Dimensions(
    @SerializedName("height")
    val height: Int? = null,
    @SerializedName("width")
    val width: Int? = null
)

data class DisplayResource(
    @SerializedName("src")
    val src: String? = null,
    @SerializedName("config_width")
    val configWidth: Int? = null,
    @SerializedName("config_height")
    val configHeight: Int? = null
)

data class DashInfo(
    @SerializedName("is_dash_eligible")
    val isDashEligible: Boolean? = null,
    @SerializedName("video_dash_manifest")
    val videoDashManifest: Any? = null,
    @SerializedName("number_of_qualities")
    val numberOfQualities: Int? = null
)

data class MediaToTaggedUser(
    @SerializedName("edges")
    val edges: List<MediaToTaggedUserEdge>? = null
)

data class MediaToTaggedUserEdge(
    @SerializedName("node")
    val node: MediaToTaggedUserNode? = null
)

data class MediaToTaggedUserNode(
    @SerializedName("user")
    val user: User? = null,
    @SerializedName("x")
    val x: Double? = null,
    @SerializedName("y")
    val y: Double? = null
)

data class User(
    @SerializedName("full_name")
    val fullName: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("is_verified")
    val isVerified: Boolean? = null,
    @SerializedName("profile_pic_url")
    val profilePicUrl: String? = null,
    @SerializedName("username")
    val username: String? = null
)

data class MediaToCaption(
    @SerializedName("edges")
    val edges: List<MediaToCaptionEdge>? = null
)

data class MediaToCaptionEdge(
    @SerializedName("node")
    val node: MediaToCaptionNode? = null
)

data class MediaToCaptionNode(
    @SerializedName("text")
    val text: String? = null
)

data class MediaToParentComment(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("page_info")
    val pageInfo: MediaToParentCommentPageInfo? = null,
    @SerializedName("edges")
    val edges: List<MediaToParentCommentEdge>? = null
)

data class MediaToParentCommentPageInfo(
    @SerializedName("has_next_page")
    val hasNextPage: Boolean? = null,
    @SerializedName("end_cursor")
    val endCursor: String? = null
)

data class MediaToParentCommentEdge(
    @SerializedName("node")
    val node: MediaToParentCommentNode? = null
)

data class MediaToParentCommentNode(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("text")
    val text: String? = null,
    @SerializedName("created_at")
    val createdAt: Int? = null,
    @SerializedName("did_report_as_spam")
    val didReportAsSpam: Boolean? = null,
    @SerializedName("owner")
    val owner: MediaToParentCommentOwner? = null,
    @SerializedName("viewer_has_liked")
    val viewerHasLiked: Boolean? = null,
    @SerializedName("edge_liked_by")
    val likedBy: MediaToParentCommentLikedBy? = null,
    @SerializedName("is_restricted_pending")
    val isRestrictedPending: Boolean? = null,
    @SerializedName("edge_threaded_comments")
    val threadedComments: ThreadedComments? = null
)

data class MediaToParentCommentOwner(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("is_verified")
    val isVerified: Boolean? = null,
    @SerializedName("profile_pic_url")
    val profilePicUrl: String? = null,
    @SerializedName("username")
    val username: String? = null
)

data class OwnerToTimelineMedia(
    @SerializedName("count")
    val count: Int? = null
)

data class FollowedBy(
    @SerializedName("count")
    val count: Int? = null
)

data class MediaToParentCommentLikedBy(
    @SerializedName("count")
    val count: Int? = null
)

data class ThreadedComments(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("page_info")
    val pageInfo: ThreadedCommentsPageInfo? = null,
    @SerializedName("edges")
    val edges: List<Any>? = null
)

data class ThreadedCommentsPageInfo(
    @SerializedName("has_next_page")
    val hasNextPage: Boolean? = null,
    @SerializedName("end_cursor")
    val endCursor: String? = null
)

data class MediaToHoistedComment(
    @SerializedName("edges")
    val edges: List<Any>? = null
)

data class MediaPreviewComment(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("edges")
    val edges: List<MediaPreviewCommentEdge>? = null
)

data class MediaPreviewCommentEdge(
    @SerializedName("node")
    val node: MediaPreviewCommentNode? = null
)

data class MediaPreviewCommentNode(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("text")
    val text: String? = null,
    @SerializedName("created_at")
    val createdAt: Int? = null,
    @SerializedName("did_report_as_spam")
    val didReportAsSpam: Boolean? = null,
    @SerializedName("owner")
    val owner: MediaPreviewCommentOwner? = null,
    @SerializedName("viewer_has_liked")
    val viewerHasLiked: Boolean? = null,
    @SerializedName("edge_liked_by")
    val likedBy: MediaPreviewCommentLikedBy? = null,
    @SerializedName("is_restricted_pending")
    val isRestrictedPending: Boolean? = null
)

data class MediaPreviewCommentOwner(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("is_verified")
    val isVerified: Boolean? = null,
    @SerializedName("profile_pic_url")
    val profilePicUrl: String? = null,
    @SerializedName("username")
    val username: String? = null
)

data class MediaPreviewCommentLikedBy(
    @SerializedName("count")
    val count: Int? = null
)

data class MediaPreviewLike(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("edges")
    val edges: List<Any>? = null
)

data class MediaToSponsorUser(
    @SerializedName("edges")
    val edges: List<Any>? = null
)

data class Location(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("has_public_page")
    val hasPublicPage: Boolean? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("slug")
    val slug: String? = null,
    @SerializedName("address_json")
    val addressJson: String? = null
)

data class Owner(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("is_verified")
    val isVerified: Boolean? = null,
    @SerializedName("profile_pic_url")
    val profilePicUrl: String? = null,
    @SerializedName("username")
    val username: String? = null,
    @SerializedName("blocked_by_viewer")
    val blockedByViewer: Boolean? = null,
    @SerializedName("restricted_by_viewer")
    val restrictedByViewer: Any? = null,
    @SerializedName("followed_by_viewer")
    val followedByViewer: Boolean? = null,
    @SerializedName("full_name")
    val fullName: String? = null,
    @SerializedName("has_blocked_viewer")
    val hasBlockedViewer: Boolean? = null,
    @SerializedName("is_private")
    val isPrivate: Boolean? = null,
    @SerializedName("is_unpublished")
    val isUnpublished: Boolean? = null,
    @SerializedName("requested_by_viewer")
    val requestedByViewer: Boolean? = null,
    @SerializedName("edge_owner_to_timeline_media")
    val ownerToTimelineMedia: OwnerToTimelineMedia? = null,
    @SerializedName("edge_followed_by")
    val followedBy: FollowedBy? = null
)

data class WebMediaToRelatedMedia(
    @SerializedName("edges")
    val edges: List<Any>? = null
)

data class SidecarToChildren(
    @SerializedName("edges")
    val edges: List<SidecarToChildrenEdge>? = null
)

data class SidecarToChildrenEdge(
    @SerializedName("node")
    val node: ShortcodeMedia? = null
)

data class RelatedProfiles(
    @SerializedName("edges")
    val edges: List<Any>? = null
)