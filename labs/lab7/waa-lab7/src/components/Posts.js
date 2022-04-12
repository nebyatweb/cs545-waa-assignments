import Post from "./Post";

const Posts = (props) => {
    const posts = props.posts.map(post => {
        return <Post
            title={post.title}
            author={post.author}
            id={post.id}
            key={post.id}
        />
    });
    return posts;
}

export default Posts;