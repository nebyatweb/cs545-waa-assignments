import Posts from "../components/Posts";
import {useState} from 'react';

export default function Dashboard() {
    const [postsState, setPostsState] = useState(
        [
            {id: 111, title: "Happiness", author: "John"},
            {id: 112, title: "MIU", author: "Dean"},
            {id: 113, title: "Enjoy Life", author: "Jasmine"}

        ]
    );

    const [title, setTitle] = useState('')

    const [postState, setPostState] = useState({})

    const updateName = () => {
        let newPost = [...postsState]
        newPost[0].title = title;
        setPostsState(newPost);
    }

    const updateButtonClicked = (id) => {
        let postObj = postsState.find( s => s.id == id);
        setPostState(postObj);
    }

    return (
        <div>
            <Posts posts={postsState} postState = {(id) => updateButtonClicked(id)} />
            <div className="updateTitle">
                <input type="text" value={title} onChange = {e => setTitle(e.target.value)} />
                <button onClick={updateName}>Change Name</button>
            </div>
        </div>
    )
}
