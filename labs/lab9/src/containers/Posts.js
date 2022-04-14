import { useEffect, useState } from "react";
import axios from "axios";
import Post from "../components/Post";

const Posts = (props) => {
    const [posts, setPosts] = useState([
        {id: 0, title:"", content: "", author: ""}
    ]);

    const fetchPosts = () => {
        axios.get('http://localhost:8080/api/v1/posts').then(res => {
            setPosts(res.data)
        }).catch(error => console.log(error))
    }

    useEffect(() => {
        fetchPosts();
    },
    [props.fetchFlag])

    const postsList = posts.map(post => {
        return <Post  author={post.author}
                      id={post.id} 
                      title={post.title} 
                      key={post.id}
                      content={post.content}
                      setSelected={() => {
                         props.setSelected(post.id)
                     }}/>
    });

    return ( 
        <div>
            {postsList}
        </div>
    );
}
 
export default Posts;