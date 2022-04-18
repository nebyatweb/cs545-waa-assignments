import { link } from "react-router-dom";

const Header = () => {
  return (
    <header>
      <nav>
        <ul>
          <li>
            <link to="/posts"> Posts </link>
          </li>
          <li>
            <link to="/create-post"> New Post</link>
          </li>
        </ul>
      </nav>
    </header>
  );
};

export default Header;
