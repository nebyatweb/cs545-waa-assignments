import Posts from "../components/Posts";
import {useState} from 'react';
import NewPost from "../components/NewPost"

export default function Dashboard() {
    let i = 114;
    const [postsState, setPostsState] = useState(
        [
            {id: 111, title: "Happiness", author: "John"},
            {id: 112, title: "MIU", author: "Dean"},
            {id: 113, title: "Enjoy Life", author: "Jasmine"}

        ]
    );

    const [postState, setPostState] = useState(
        {
            title: "",
            author: ""
        }
        
    )

    const onChange = (events) => {
        const copy = { ...postState };
        copy[events.target.title] = events.target.value;
        setPostState(copy);
    }

    const addButtonClicked = () => {
        const copy = { ...postState };
        copy.id = i;
        i++;
        const copyPostsState = [...postsState]
        copyPostsState.push(copy);
        setPostsState(copyPostsState);
    }

    return (
        <div>
            <Posts posts={postsState} />
            <NewPost
                title={postState.title}
                author={postState.author}
                onChange={(event) => { onChange(event) }}
                addButtonClicked={addButtonClicked}
            />
        </div>
    )
}
