package com.example.gitclosure.Models.ApiModel


import com.google.gson.annotations.SerializedName

class myData : ArrayList<myData.myDataItem>(){

    data class myDataItem(
        @SerializedName("active_lock_reason")
        val activeLockReason: Any?,
        @SerializedName("assignee")
        val assignee: Assignee,
        @SerializedName("assignees")
        val assignees: List<Assignee>,
        @SerializedName("author_association")
        val authorAssociation: String,
        @SerializedName("body")
        val body: String?,
        @SerializedName("closed_at")
        val closedAt: String,
        @SerializedName("comments")
        val comments: Int,
        @SerializedName("comments_url")
        val commentsUrl: String,
        @SerializedName("created_at")
        val createdAt: String,
        @SerializedName("draft")
        val draft: Boolean?,
        @SerializedName("events_url")
        val eventsUrl: String,
        @SerializedName("html_url")
        val htmlUrl: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("labels")
        val labels: List<Label>,
        @SerializedName("labels_url")
        val labelsUrl: String,
        @SerializedName("locked")
        val locked: Boolean,
        @SerializedName("milestone")
        val milestone: Any?,
        @SerializedName("node_id")
        val nodeId: String,
        @SerializedName("number")
        val number: Int,
        @SerializedName("performed_via_github_app")
        val performedViaGithubApp: Any?,
        @SerializedName("pull_request")
        val pullRequest: PullRequest?,
        @SerializedName("reactions")
        val reactions: Reactions,
        @SerializedName("repository")
        val repository: Repository,
        @SerializedName("repository_url")
        val repositoryUrl: String,
        @SerializedName("state")
        val state: String,
        @SerializedName("state_reason")
        val stateReason: String?,
        @SerializedName("timeline_url")
        val timelineUrl: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("updated_at")
        val updatedAt: String,
        @SerializedName("url")
        val url: String,
        @SerializedName("user")
        val user: User
    ) {
        data class Assignee(
            @SerializedName("avatar_url")
            val avatarUrl: String,
            @SerializedName("events_url")
            val eventsUrl: String,
            @SerializedName("followers_url")
            val followersUrl: String,
            @SerializedName("following_url")
            val followingUrl: String,
            @SerializedName("gists_url")
            val gistsUrl: String,
            @SerializedName("gravatar_id")
            val gravatarId: String,
            @SerializedName("html_url")
            val htmlUrl: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("login")
            val login: String,
            @SerializedName("node_id")
            val nodeId: String,
            @SerializedName("organizations_url")
            val organizationsUrl: String,
            @SerializedName("received_events_url")
            val receivedEventsUrl: String,
            @SerializedName("repos_url")
            val reposUrl: String,
            @SerializedName("site_admin")
            val siteAdmin: Boolean,
            @SerializedName("starred_url")
            val starredUrl: String,
            @SerializedName("subscriptions_url")
            val subscriptionsUrl: String,
            @SerializedName("type")
            val type: String,
            @SerializedName("url")
            val url: String
        )
    
        data class Label(
            @SerializedName("color")
            val color: String,
            @SerializedName("default")
            val default: Boolean,
            @SerializedName("description")
            val description: String,
            @SerializedName("id")
            val id: Long,
            @SerializedName("name")
            val name: String,
            @SerializedName("node_id")
            val nodeId: String,
            @SerializedName("url")
            val url: String
        )
    
        data class PullRequest(
            @SerializedName("diff_url")
            val diffUrl: String,
            @SerializedName("html_url")
            val htmlUrl: String,
            @SerializedName("merged_at")
            val mergedAt: String,
            @SerializedName("patch_url")
            val patchUrl: String,
            @SerializedName("url")
            val url: String
        )
    
        data class Reactions(
            @SerializedName("confused")
            val confused: Int,
            @SerializedName("eyes")
            val eyes: Int,
            @SerializedName("heart")
            val heart: Int,
            @SerializedName("hooray")
            val hooray: Int,
            @SerializedName("laugh")
            val laugh: Int,
            @SerializedName("rocket")
            val rocket: Int,
            @SerializedName("total_count")
            val totalCount: Int,
            @SerializedName("url")
            val url: String,
//            @SerializedName("+1")
//           // val x1: Int,
//            @SerializedName("-1")
//            //val x1: Int
        )
    
        data class Repository(
            @SerializedName("allow_forking")
            val allowForking: Boolean,
            @SerializedName("archive_url")
            val archiveUrl: String,
            @SerializedName("archived")
            val archived: Boolean,
            @SerializedName("assignees_url")
            val assigneesUrl: String,
            @SerializedName("blobs_url")
            val blobsUrl: String,
            @SerializedName("branches_url")
            val branchesUrl: String,
            @SerializedName("clone_url")
            val cloneUrl: String,
            @SerializedName("collaborators_url")
            val collaboratorsUrl: String,
            @SerializedName("comments_url")
            val commentsUrl: String,
            @SerializedName("commits_url")
            val commitsUrl: String,
            @SerializedName("compare_url")
            val compareUrl: String,
            @SerializedName("contents_url")
            val contentsUrl: String,
            @SerializedName("contributors_url")
            val contributorsUrl: String,
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("default_branch")
            val defaultBranch: String,
            @SerializedName("deployments_url")
            val deploymentsUrl: String,
            @SerializedName("description")
            val description: String?,
            @SerializedName("disabled")
            val disabled: Boolean,
            @SerializedName("downloads_url")
            val downloadsUrl: String,
            @SerializedName("events_url")
            val eventsUrl: String,
            @SerializedName("fork")
            val fork: Boolean,
            @SerializedName("forks")
            val forks: Int,
            @SerializedName("forks_count")
            val forksCount: Int,
            @SerializedName("forks_url")
            val forksUrl: String,
            @SerializedName("full_name")
            val fullName: String,
            @SerializedName("git_commits_url")
            val gitCommitsUrl: String,
            @SerializedName("git_refs_url")
            val gitRefsUrl: String,
            @SerializedName("git_tags_url")
            val gitTagsUrl: String,
            @SerializedName("git_url")
            val gitUrl: String,
            @SerializedName("has_discussions")
            val hasDiscussions: Boolean,
            @SerializedName("has_downloads")
            val hasDownloads: Boolean,
            @SerializedName("has_issues")
            val hasIssues: Boolean,
            @SerializedName("has_pages")
            val hasPages: Boolean,
            @SerializedName("has_projects")
            val hasProjects: Boolean,
            @SerializedName("has_wiki")
            val hasWiki: Boolean,
            @SerializedName("homepage")
            val homepage: Any?,
            @SerializedName("hooks_url")
            val hooksUrl: String,
            @SerializedName("html_url")
            val htmlUrl: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("is_template")
            val isTemplate: Boolean,
            @SerializedName("issue_comment_url")
            val issueCommentUrl: String,
            @SerializedName("issue_events_url")
            val issueEventsUrl: String,
            @SerializedName("issues_url")
            val issuesUrl: String,
            @SerializedName("keys_url")
            val keysUrl: String,
            @SerializedName("labels_url")
            val labelsUrl: String,
            @SerializedName("language")
            val language: String,
            @SerializedName("languages_url")
            val languagesUrl: String,
            @SerializedName("license")
            val license: Any?,
            @SerializedName("merges_url")
            val mergesUrl: String,
            @SerializedName("milestones_url")
            val milestonesUrl: String,
            @SerializedName("mirror_url")
            val mirrorUrl: Any?,
            @SerializedName("name")
            val name: String,
            @SerializedName("node_id")
            val nodeId: String,
            @SerializedName("notifications_url")
            val notificationsUrl: String,
            @SerializedName("open_issues")
            val openIssues: Int,
            @SerializedName("open_issues_count")
            val openIssuesCount: Int,
            @SerializedName("owner")
            val owner: Owner,
            @SerializedName("permissions")
            val permissions: Permissions,
            @SerializedName("private")
            val `private`: Boolean,
            @SerializedName("pulls_url")
            val pullsUrl: String,
            @SerializedName("pushed_at")
            val pushedAt: String,
            @SerializedName("releases_url")
            val releasesUrl: String,
            @SerializedName("size")
            val size: Int,
            @SerializedName("ssh_url")
            val sshUrl: String,
            @SerializedName("stargazers_count")
            val stargazersCount: Int,
            @SerializedName("stargazers_url")
            val stargazersUrl: String,
            @SerializedName("statuses_url")
            val statusesUrl: String,
            @SerializedName("subscribers_url")
            val subscribersUrl: String,
            @SerializedName("subscription_url")
            val subscriptionUrl: String,
            @SerializedName("svn_url")
            val svnUrl: String,
            @SerializedName("tags_url")
            val tagsUrl: String,
            @SerializedName("teams_url")
            val teamsUrl: String,
            @SerializedName("topics")
            val topics: List<Any>,
            @SerializedName("trees_url")
            val treesUrl: String,
            @SerializedName("updated_at")
            val updatedAt: String,
            @SerializedName("url")
            val url: String,
            @SerializedName("visibility")
            val visibility: String,
            @SerializedName("watchers")
            val watchers: Int,
            @SerializedName("watchers_count")
            val watchersCount: Int,
            @SerializedName("web_commit_signoff_required")
            val webCommitSignoffRequired: Boolean
        ) {
            data class Owner(
                @SerializedName("avatar_url")
                val avatarUrl: String,
                @SerializedName("events_url")
                val eventsUrl: String,
                @SerializedName("followers_url")
                val followersUrl: String,
                @SerializedName("following_url")
                val followingUrl: String,
                @SerializedName("gists_url")
                val gistsUrl: String,
                @SerializedName("gravatar_id")
                val gravatarId: String,
                @SerializedName("html_url")
                val htmlUrl: String,
                @SerializedName("id")
                val id: Int,
                @SerializedName("login")
                val login: String,
                @SerializedName("node_id")
                val nodeId: String,
                @SerializedName("organizations_url")
                val organizationsUrl: String,
                @SerializedName("received_events_url")
                val receivedEventsUrl: String,
                @SerializedName("repos_url")
                val reposUrl: String,
                @SerializedName("site_admin")
                val siteAdmin: Boolean,
                @SerializedName("starred_url")
                val starredUrl: String,
                @SerializedName("subscriptions_url")
                val subscriptionsUrl: String,
                @SerializedName("type")
                val type: String,
                @SerializedName("url")
                val url: String
            )
    
            data class Permissions(
                @SerializedName("admin")
                val admin: Boolean,
                @SerializedName("maintain")
                val maintain: Boolean,
                @SerializedName("pull")
                val pull: Boolean,
                @SerializedName("push")
                val push: Boolean,
                @SerializedName("triage")
                val triage: Boolean
            )
        }
    
        data class User(
            @SerializedName("avatar_url")
            val avatarUrl: String,
            @SerializedName("events_url")
            val eventsUrl: String,
            @SerializedName("followers_url")
            val followersUrl: String,
            @SerializedName("following_url")
            val followingUrl: String,
            @SerializedName("gists_url")
            val gistsUrl: String,
            @SerializedName("gravatar_id")
            val gravatarId: String,
            @SerializedName("html_url")
            val htmlUrl: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("login")
            val login: String,
            @SerializedName("node_id")
            val nodeId: String,
            @SerializedName("organizations_url")
            val organizationsUrl: String,
            @SerializedName("received_events_url")
            val receivedEventsUrl: String,
            @SerializedName("repos_url")
            val reposUrl: String,
            @SerializedName("site_admin")
            val siteAdmin: Boolean,
            @SerializedName("starred_url")
            val starredUrl: String,
            @SerializedName("subscriptions_url")
            val subscriptionsUrl: String,
            @SerializedName("type")
            val type: String,
            @SerializedName("url")
            val url: String
        )
    }
}